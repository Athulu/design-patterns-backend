package designpatternsbackend.services;

import designpatternsbackend.repositories.ResultsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ResultsService {
    private final ResultsRepository resultsRepository;
}
