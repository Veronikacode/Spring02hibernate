package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
