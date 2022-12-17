package designpatternsbackend.docker;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class CommandService {
    final ConfigCommandService connfigCommandService;

    public List<String> runCommand(String nameFile, String args) {
        List<String> cmd = connfigCommandService.getJarRun();
        List<String> exec = new ArrayList<>(cmd);
        exec.add(nameFile);
        if(!args.isEmpty()) {
            exec.add(args);
        }
        return exec;
    }

    public List<String> killCommand(List<String> command) {
        List<String> exec = new ArrayList<>(connfigCommandService.getKillProcess());
        exec.add(String.join(" ", command));
        return exec;
    }
}
