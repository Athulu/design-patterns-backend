package designpatternsbackend.docker;

import designpatternsbackend.docker.TarDTO;
import designpatternsbackend.docker.exceptions.DockerExceptions;
import lombok.AllArgsConstructor;
import org.apache.commons.compress.archivers.ArchiveOutputStream;
import org.apache.commons.compress.archivers.ArchiveStreamFactory;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveOutputStream;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.StandardCharsets;

@Service
@AllArgsConstructor
public class FileService {
    InputStream getInputStream(MultipartFile file) {
        try {
            return new BufferedInputStream(file.getInputStream());
        } catch (Exception e) {
            throw new DockerExceptions("File empty");
        }
    }

    InputStream getInputStream(String content) {
        return new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
    }
    InputStream returnTarFile(InputStream in) throws IOException {
        PipedInputStream zipped = new PipedInputStream();
        PipedOutputStream pipe = new PipedOutputStream(zipped);
                    try(OutputStream zipper = new TarArchiveOutputStream(pipe)){
                        IOUtils.copy(in, zipper);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
        return zipped;
    }

    public String getName(MultipartFile multipartFile) {
        return multipartFile.getOriginalFilename();
    }

    public File getOutputStream(String name, MultipartFile multipartFile) {
        try {
            File file = new File(name);

            try (OutputStream os = new FileOutputStream(file)) {
                os.write(multipartFile.getBytes());
            }

            return file;
        } catch (Exception e) {
            throw new DockerExceptions("File not found");
        }
    }

    public File getOutputStream(String name, InputStream inputStream) {
        try {
            File file = new File(name);

            try (OutputStream os = new FileOutputStream(file)) {
                os.write(inputStream.readAllBytes());
            }

            return file;
        } catch (Exception e) {
            throw new DockerExceptions("File not found");
        }
    }

    public TarDTO parseToTar(File file) {
        try {
            OutputStream tar_output = new FileOutputStream(file.getAbsolutePath().concat(".tar"));

            ArchiveOutputStream my_tar_ball = new ArchiveStreamFactory().createArchiveOutputStream(ArchiveStreamFactory.TAR, tar_output);

            TarArchiveEntry tar_file = null;
            tar_file = new TarArchiveEntry(file.getName());
            tar_file.setSize(file.length());
            my_tar_ball.putArchiveEntry(tar_file);

            IOUtils.copy(new FileInputStream(file), my_tar_ball);
            my_tar_ball.closeArchiveEntry();
            my_tar_ball.close();
            file.delete();

            File initialFile = new File(file.getAbsolutePath().concat(".tar"));
            return new TarDTO(initialFile, new FileInputStream(initialFile));
        } catch (Exception e) {
            throw new DockerExceptions("Exaption");
        }
    }

    public void deleteFile(File file) {
        file.delete();
    }

}
