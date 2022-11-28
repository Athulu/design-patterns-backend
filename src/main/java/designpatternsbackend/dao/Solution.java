package designpatternsbackend.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Solution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long solutionID;
    private Integer resultsPoints;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

    @OneToMany(mappedBy = "solution", cascade = CascadeType.ALL)
    List<Result> resultList = new ArrayList<>();
}
