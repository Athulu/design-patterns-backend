package designpatternsbackend.xapi.dao;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="result_id")
    private Long resultID;
    private Boolean isCorrect;
    private String outputData;
    private String cookie;

    @ManyToOne
    @JoinColumn(name = "test_id")
    private Test test;
}
