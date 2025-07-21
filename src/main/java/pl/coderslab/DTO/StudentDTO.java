package pl.coderslab.DTO;

import lombok.Data;

@Data
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String indexNumber;
    private double averageGrade;
}
