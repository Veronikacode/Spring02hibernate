package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Book;
import pl.coderslab.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;


    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Optional<Book> maybeBook = bookRepository.findById(id);
        if (maybeBook.isPresent()) {
            Book existingBook = maybeBook.get();
            existingBook.setTitle(book.getTitle());
            existingBook.setIsbn(book.getIsbn());
            existingBook.setPublisher(book.getPublisher());
            existingBook.setAuthor(book.getAuthor());
            existingBook.setType(book.getType());
            return bookRepository.save(existingBook);
        }
        throw new IllegalArgumentException("Book with id " + id + " not found");
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
