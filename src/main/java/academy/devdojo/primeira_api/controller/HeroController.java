package academy.devdojo.primeira_api.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/hero")
public class HeroController{
    private static final List<String> HEROES = List.of("Homem de Ferro","Homem Aranha","Capitão América");

}
