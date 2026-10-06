package academy.devdojo.primeira_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "v1/animes")
public class AnimeController {

    @GetMapping
    public List<String> listAll(){
        return List.of("Kakegurui","Full-Metal","Re:Zero");
    }
}
