package designpatternsbackend.docker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MessageResponseUploadDTO {
    private Integer status;
    private String message;
}
