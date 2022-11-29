package designpatternsbackend.docker;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Getter
public class ConfigDockerService {
    @Value("${spring.docker.username}")         private String username;
    @Value("${spring.docker.password}")         private String password;
    @Value("${spring.docker.host}")             private String host;
    @Value("${spring.docker.sshPort}")          private Integer sshPort;
    @Value("${spring.docker.dockerPort}")       private String dockerPort;
    @Value("${spring.docker.sessionTimeout}")   private Integer sessionTimeout;
    @Value("${spring.docker.channelTimeout}")   private Integer channelTimeout;
    @Value("${spring.docker.pathFile}")         private String pathFile;
    @Value("${spring.docker.nameImage}")        private String nameImage;
    @Value("${spring.docker.prefixContainer}")  private String prefixContainer;
}
