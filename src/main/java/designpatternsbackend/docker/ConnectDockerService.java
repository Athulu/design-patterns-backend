package designpatternsbackend.docker;

import designpatternsbackend.docker.exceptions.DockerExceptions;
import com.jcraft.jsch.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
@AllArgsConstructor
public class ConnectDockerService {
    final ConfigDockerService configDockerService;

    public void uploadFile(InputStream inputStream, String remoteFileLocationPath, String fileName) {
        createFolder(remoteFileLocationPath);
        ChannelSftp channelSftp = createChannelSftp(createSession());
        try {
            channelSftp.put(inputStream, remoteFileLocationPath + fileName);
        } catch(SftpException e) {
            throw new DockerExceptions("Problem z wrzuceniem pliku: " + e);
        } finally {
            disconnectChannel(channelSftp);
        }
    }

    public void createFolder(String remotePath) {
        String command = "mkdir -p " + remotePath;
        commandExec(createSession(), command);
    }

    public InputStream downloadFile(String remoteFilePath) {
        String command = "scp -f " + remoteFilePath;
        return commandExec(createSession(), command);
    }

    private Session createSession() {
        try {
            JSch jSch = new JSch();

            Session session = jSch.getSession(
                    configDockerService.getUsername(),
                    configDockerService.getHost(),
                    configDockerService.getSshPort());

            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(configDockerService.getPassword());
            session.connect(configDockerService.getSessionTimeout());

            return session;

        } catch (JSchException e) {
            throw new DockerExceptions("Sesja nie została uruchomiona: " + e);
        }
    }

    private ChannelSftp createChannelSftp(Session session) {
        try {
            Channel channel = session.openChannel("sftp");
            channel.connect(configDockerService.getChannelTimeout());
            return (ChannelSftp) channel;

        } catch (JSchException e) {
            throw new DockerExceptions("Problem z połączeniem sftp: " + e);
        }
    }

    private InputStream commandExec(Session session, String command) {
        try {
            Channel channel = session.openChannel("exec");
            ((ChannelExec)channel).setCommand(command);

            InputStream in = channel.getInputStream();
            channel.connect();

            disconnectChannel(channel);

            return in;
        } catch (Exception e) {
            throw new DockerExceptions("Problem z połączeniem exec: " + e);
        }
    }

    private void disconnectChannel(Channel channel) {
        try {

            if( channel == null)
                return;

            if(channel.isConnected())
                channel.disconnect();

            if(channel.getSession() != null)
                channel.getSession().disconnect();

        } catch(Exception e) {
            throw new DockerExceptions("Problem z zamknięm: " + e);
        }
    }
}

