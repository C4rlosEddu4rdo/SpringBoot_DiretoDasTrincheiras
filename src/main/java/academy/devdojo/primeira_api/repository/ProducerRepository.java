package academy.devdojo.primeira_api.repository;

import academy.devdojo.primeira_api.domain.Producer;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProducerRepository {

    private static final List<Producer> PRODUCERS = new ArrayList<>();
    static {
        PRODUCERS.addAll(List.of(Producer.builder().id(1L).name("Dexter").createdAt(LocalDateTime.now()).build(),
                (Producer.builder().id(2L).name("Dark").createdAt(LocalDateTime.now()).build())));
    }

    public List<Producer> listAll() {
        return PRODUCERS;
    }
    public Optional<Producer> findById(Long id) {
        return PRODUCERS.stream().filter(Producer -> Producer.getId().equals(id)).findFirst();
    }
    public List<Producer> findByName(String name) {
        return PRODUCERS.stream().filter(p -> p.getName().equalsIgnoreCase(name)).toList();
    }

    public Producer save (Producer producer) {
        PRODUCERS.add(producer);
        return producer;
    }
    public void delete(Producer producer) {
        PRODUCERS.remove(producer);

    }
    public void update(Producer producer) {
        delete(producer);
        save(producer);
    }

}
