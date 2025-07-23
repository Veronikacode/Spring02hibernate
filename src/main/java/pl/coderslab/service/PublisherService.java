package pl.coderslab.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.PublisherRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public List<Publisher> getAllPublishers() {
        return publisherRepository.findAll();
    }

    public Optional<Publisher> getPublisherById(Long id) {
        return publisherRepository.findById(id);
    }

    public Publisher createPublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher updatePublisher(Long id, Publisher publisher) {
        Optional<Publisher> maybePublisher = publisherRepository.findById(id);
        if (maybePublisher.isPresent()) {
            Publisher existingPublisher = maybePublisher.get();
            existingPublisher.setName(publisher.getName());
            existingPublisher.setCity(publisher.getCity());
            existingPublisher.setZipCode(publisher.getZipCode());
            existingPublisher.setAddress(publisher.getAddress());
            return publisherRepository.save(existingPublisher);
        }
        throw new IllegalArgumentException("Publisher with id " + id + " not found");
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }
}
