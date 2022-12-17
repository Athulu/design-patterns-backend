package designpatternsbackend.docker;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Getter
public class ConfigCommandService {
    final private String[] runContainer     = {"sleep", "600"};
    final private List<String> jarRun       = List.of("java", "-jar");
    final private List<String> runInfinity  = List.of("&");
    final private List<String> killProcess  = List.of("kill", "-9");
}
