package designpatternsbackend.docker;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.FileInputStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarDTO {
    private File initialFile;
    private FileInputStream targetStream;
}