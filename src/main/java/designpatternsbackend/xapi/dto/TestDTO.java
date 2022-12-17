package designpatternsbackend.xapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TestDTO {
    private Long testID;
    private String inputData;
    private String outputData;
}
