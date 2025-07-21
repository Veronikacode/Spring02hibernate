package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.DTO.StudentDTO;
import pl.coderslab.entity.Student;
import pl.coderslab.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<StudentDTO> getAllStudents() {
        return studentRepository.findAll().stream()
                .map(student -> {
                    StudentDTO dto = new StudentDTO();
                    dto.setId(student.getId());
                    dto.setFirstName(student.getFirstName());
                    dto.setLastName(student.getLastName());
                    dto.setIndexNumber(student.getIndexNumber());
                    dto.setAverageGrade(student.getAverageGrade());
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public void createTestStudent() {
        Student student = new Student();
        student.setFirstName("Jan");
        student.setLastName("Kowalski");
        student.setIndexNumber("123456");
        student.setAverageGrade(4.5);
        studentRepository.save(student);
    }
}