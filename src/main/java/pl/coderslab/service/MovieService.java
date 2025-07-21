package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.DTO.MovieDTO;
import pl.coderslab.entity.Movie;
import pl.coderslab.repository.MovieRepository;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Optional<MovieDTO> getMovieById(Long id) {
        return movieRepository.findById(id)
                .map(this::mapToDTO);
    }

    private MovieDTO mapToDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setReleaseYear(movie.getReleaseYear());
        movieDTO.setGenres(movie.getGenres().stream()
                .map(genre -> genre.getName())
                .collect(Collectors.toList()));
        movieDTO.setRating(movie.getRating());
        return movieDTO;
    }
}