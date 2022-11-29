package designpatternsbackend.xapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResultDTO2 {
    private Boolean isCorrect;
    private String outputData;
    private Long testID;
}
