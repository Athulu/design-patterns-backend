package designpatternsbackend.services;

import designpatternsbackend.repositories.SolutionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SolutionsService {
    private final SolutionsRepository solutionsRepository;
}
