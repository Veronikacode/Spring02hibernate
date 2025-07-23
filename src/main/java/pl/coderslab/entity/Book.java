package pl.coderslab.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String isbn;
    private String author;
    private String type;

    @Size(min = 5, message = "Tytuł musi mieć co najmniej 5 znaków.")
    private String title;

    @NotBlank(message = "Pole 'publisher' jest wymagane.")
    private String publisher;

    @Min(value = 1, message = "Ocena musi być co najmniej 1.")
    @Max(value = 10, message = "Ocena nie może być większa niż 10.")
    private Integer rating;

    @Size(max = 600, message = "Opis nie może przekraczać 600 znaków.")
    private String description;

    @Min(value = 2, message = "Liczba stron musi być większa niż 1.")
    private Integer pages;

    public Book(String isbn, String title, String author, String publisher, String type) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.type = type;
    }
}
