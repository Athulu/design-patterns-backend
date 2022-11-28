package designpatternsbackend.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resultID;
    private Boolean isCorrect;
    private String outputData;
    @ManyToOne
    @JoinColumn(name = "solution_id")
    private Solution solution;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
}
