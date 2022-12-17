package designpatternsbackend.docker.exceptions;

import lombok.Getter;

@Getter
public class DockerExceptions extends RuntimeException {
    private final String type = "solutionUploadFailed";
    public DockerExceptions(String message) {
        super(message);
    }
}
