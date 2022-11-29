package designpatternsbackend.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.core.DefaultDockerClientConfig;
import com.github.dockerjava.core.DockerClientConfig;
import com.github.dockerjava.core.DockerClientImpl;
import com.github.dockerjava.core.command.ExecStartResultCallback;
import com.github.dockerjava.httpclient5.ApacheDockerHttpClient;
import com.github.dockerjava.transport.DockerHttpClient;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class DockerApiService {
    ConfigDockerService configDockerService;

    private DockerClientConfig createDockerClientConfig() {
        return DefaultDockerClientConfig.createDefaultConfigBuilder()
                .withDockerHost("tcp://" + configDockerService.getHost() + ":" + configDockerService.getDockerPort())
                .withDockerTlsVerify(false)
                .build();
    }

    private DockerHttpClient createDockerHttpClient(DockerClientConfig config) {
        return new ApacheDockerHttpClient.Builder()
                .dockerHost(config.getDockerHost())
                .sslConfig(config.getSSLConfig())
                .build();
    }

    public DockerClient getInstance() {
        DockerClientConfig config = createDockerClientConfig();
        DockerHttpClient httpClient =  createDockerHttpClient(config);
        return DockerClientImpl.getInstance(config, httpClient);
    }

    public String createContainer(DockerClient dockerClient, String nameContainer, String[] cmd) {
        return dockerClient.createContainerCmd(configDockerService.getNameImage())
                .withName(nameContainer)
                .withCmd(cmd).exec().getId();
    }

    public void startContainer(DockerClient dockerClient, String id) {
        dockerClient.startContainerCmd(id).exec();
    }

    public void copyToContainer(DockerClient dockerClient, String id, InputStream file, String remotePath) {
        dockerClient.copyArchiveToContainerCmd(id)
                .withTarInputStream(file)
                .withRemotePath(remotePath)
                .exec();
    }

    public String execContainer(DockerClient dockerClient, String id, List<String> cmd, Long timeOut) {
        String result;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        String execId = dockerClient.execCreateCmd(id)
                .withCmd(cmd.toArray(new String[0]))
                .withAttachStdout(true)
                .withTty(true)
                .exec().getId();

        try {

            if(timeOut == 0) {
                dockerClient.execStartCmd(execId)
                        .withDetach(false)
                        .withTty(true)
                        .exec(new ExecStartResultCallback(outputStream, null))
                        .awaitCompletion();
            }else {
                dockerClient.execStartCmd(execId)
                        .withDetach(false)
                        .withTty(true)
                        .exec(new ExecStartResultCallback(outputStream, null))
                        .awaitCompletion(timeOut, TimeUnit.SECONDS);
            }

            result = outputStream.toString(StandardCharsets.UTF_8);
        } catch (Exception e) {
            result = "";
        }
        return result;
    }

    public void deleteContainer(DockerClient dockerClient, String id) {
        dockerClient.stopContainerCmd(id).exec();
        dockerClient.removeContainerCmd(id).exec();
    }
}
