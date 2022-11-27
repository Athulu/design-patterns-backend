package designpatternsbackend.dao;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Tests {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long testID;
    private String inputData;
    private String outputData;
}
