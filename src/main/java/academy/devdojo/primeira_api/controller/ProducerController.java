package academy.devdojo.primeira_api.controller;


import academy.devdojo.primeira_api.domain.Producer;
import academy.devdojo.primeira_api.dto.request.ProducerPostRequest;
import academy.devdojo.primeira_api.dto.response.ProducerResponse;
import academy.devdojo.primeira_api.mapper.ProducerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.awt.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/producers")
@Log4j2
public class ProducerController {
    private final ProducerMapper producerMapper;

    @GetMapping
    public ResponseEntity<List<Producer>> listAllOrFindyByName(@RequestParam (required = false) String name){
        log.debug("solicitação recebida para listar todos os producers, nome do parâmetro {}",name);
        var Producers = Producer.getProducers();
        if (name == null) return ResponseEntity.ok().body(Producer.getProducers());
        var producer = Producers.stream().filter(Producer -> Producer.getName().equalsIgnoreCase(name)).toList();
        return ResponseEntity.ok().body(producer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProducerResponse> findById(@PathVariable Long id){
        log.debug("solicitação recebida para encontrar producer por ID {}",id);
        var producer = Producer.getProducers().stream().filter(Producer -> Producer.getId().equals(id)).findFirst().orElse(null);
        var producerResponse = ProducerResponse.builder().name(producer.getName()).createdAt(producer.getCreatedAt()).build();
        return ResponseEntity.ok(producerResponse);
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, headers = "tutorial-api-key")
    public ResponseEntity<ProducerResponse> save(@RequestBody ProducerPostRequest  producerPostRequest){
        log.debug("solicitação para salvar producer {}", producerPostRequest);
        var producer = producerMapper.toProducer(producerPostRequest);
        Producer.getProducers().add(producer);
        var producerResponse = producerMapper.toProducerResponse(producer);

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization","My Key");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(producerResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        log.debug("deletar producer por ID {}",id);
        Producer deleteProducer = Producer.getProducers().stream().filter(Producer -> Producer.getId().equals(id)).findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID not exists"));
        Producer.getProducers().remove(deleteProducer);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }



}
