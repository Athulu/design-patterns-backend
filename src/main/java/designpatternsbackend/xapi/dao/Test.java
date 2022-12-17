package designpatternsbackend.xapi.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testID;
    private String inputData;
    private String outputData;

    @OneToMany(mappedBy = "test", cascade = CascadeType.ALL)
    private List<Result> resultList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
}
