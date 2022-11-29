package designpatternsbackend.xapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ResultDTO {
    private Long resultID;
    private Boolean isCorrect;
    private String outputData;
}
