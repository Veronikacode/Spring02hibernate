package pl.coderslab.controller;

import jakarta.validation.ConstraintViolation;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.coderslab.entity.Book;

import java.util.Set;

@RestController
public class ValidationController {

    private final Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/validate")
    public ResponseEntity<String> testValidation() {
        Book book = new Book();
        book.setTitle("Valid Title");
        book.setIsbn("1234567890123");
        book.setPublisher("Valid Publisher");
        book.setAuthor("Valid Author");
        book.setType("Valid Type");

        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        if(!violations.isEmpty()) {
            StringBuilder errorMessage = new StringBuilder("Validation errors:\n");
            for (ConstraintViolation<Book> violation : violations) {
                errorMessage.append(violation.getPropertyPath())
                        .append(": ")
                        .append(violation.getMessage())
                        .append("\n");
            }
            return ResponseEntity.badRequest().body(errorMessage.toString());
        }
        else {
            return ResponseEntity.ok("Book is valid!");
        }
    }
}
