package designpatternsbackend.services;

import designpatternsbackend.repositories.TestsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TestsService {
    private final TestsRepository testsRepository;
}
