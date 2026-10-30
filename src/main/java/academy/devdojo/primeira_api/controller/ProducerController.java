package academy.devdojo.primeira_api.controller;


import academy.devdojo.primeira_api.domain.Producer;
import academy.devdojo.primeira_api.dto.request.ProducerPostRequest;
import academy.devdojo.primeira_api.dto.request.ProducerPutRequest;
import academy.devdojo.primeira_api.dto.response.ProducerResponse;

import academy.devdojo.primeira_api.mapper.ProducerMapper;
import academy.devdojo.primeira_api.service.ProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "v1/producers")
@Log4j2
public class ProducerController {
    private final ProducerMapper producerMapper;
    private final ProducerService producerService;

    @GetMapping
    public ResponseEntity<List<ProducerResponse>> listAllOrFindyByName(@RequestParam (required = false) String name){
        log.debug("solicitação recebida para listar todos os producers, nome do parâmetro {}",name);

        var producers = producerService.findAll(name);

        List<ProducerResponse> producerResponseList = producerMapper.toProducerResponseList(producers);

        return ResponseEntity.ok(producerResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProducerResponse> findById(@PathVariable Long id){
        log.debug("solicitação recebida para encontrar producer por ID {}",id);
        Producer producer = producerService.findByIdOrElseThrow(id);
        ProducerResponse producerResponse = producerMapper.toProducerResponse(producer);
        return ResponseEntity.ok(producerResponse);
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, headers = "tutorial-api-key")
    public ResponseEntity<ProducerResponse> save(@RequestBody ProducerPostRequest  producerPostRequest){
        log.debug("solicitação para salvar producer {}", producerPostRequest);
        Producer producer = producerMapper.toProducer(producerPostRequest);
        Producer producerSaved = producerService.save(producer);
        ProducerResponse producerResponse = producerMapper.toProducerResponse(producerSaved);

        var headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization","My Key");
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(producerResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        log.debug("deletar producer por ID {}",id);
        producerService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping
    public ResponseEntity<Void> update(@RequestBody ProducerPutRequest request){
        log.debug("atualizando producer {}", request);
        Producer producer = producerMapper.toProducer(request);
        producerService.update(producer);
        return ResponseEntity.noContent().build();
    }
}
