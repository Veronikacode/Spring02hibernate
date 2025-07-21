package pl.coderslab.DTO;

import lombok.Data;

import java.util.List;

@Data
public class MovieDTO {
    private Long id;
    private String title;
    private int releaseYear;
    private List<String> genres;
    private double rating;
}