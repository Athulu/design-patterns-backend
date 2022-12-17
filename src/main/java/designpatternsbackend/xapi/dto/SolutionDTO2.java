package designpatternsbackend.xapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SolutionDTO2 {
    private Long solutionID;
    private Integer resultsPoints;
    private Long taskID;
}
