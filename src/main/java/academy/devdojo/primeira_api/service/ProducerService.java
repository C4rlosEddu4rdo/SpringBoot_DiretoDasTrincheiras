package academy.devdojo.primeira_api.service;

import academy.devdojo.primeira_api.domain.Producer;
import academy.devdojo.primeira_api.repository.ProducerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class ProducerService {
    private final ProducerRepository repository;

   public ProducerService() {
       this.repository = new ProducerRepository();

   }

    public List<Producer> findAll(String name) {
        return name == null ? repository.listAll() : repository.findByName(name);
    }
    public Producer findByIdOrElseThrow(Long id) {
       return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID not exists"));
    }
    public Producer save(Producer producer) {
        return repository.save(producer);
    }

    public void delete(Long id){
        Producer producer = findByIdOrElseThrow(id);
        repository.delete(producer);
    }
    public void update(Producer producerToUpdate) {
        Producer producer = findByIdOrElseThrow(producerToUpdate.getId());
        producer.setCreatedAt(producer.getCreatedAt());
        repository.save(producer);
    }

}
