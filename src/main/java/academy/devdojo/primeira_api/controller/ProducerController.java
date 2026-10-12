package academy.devdojo.primeira_api.controller;


import academy.devdojo.primeira_api.domain.Producer;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping(value = "v1/producers")
public class ProducerController {

    @GetMapping
    public List<Producer> listAllOrFindyByName(@RequestParam (required = false) String name){
        var Producers = Producer.getProducers();
        if (name == null) return Producers;
        return Producers.stream().filter(Producer -> Producer.getName().equalsIgnoreCase(name)).toList();
    }

    @GetMapping("{id}")
    public Producer findById(@PathVariable Long id){
        return Producer.getProducers().stream().filter(Producer -> Producer.getId().equals(id)).findFirst().orElse(null);
    }
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, headers = "tutorial-api-key")
    public Producer save(@RequestBody Producer Producer ){
        Producer.setId(Producer.getProducers().getLast().getId() + 1);
        Producer.getProducers().add(Producer);
        return Producer;
    }



}
