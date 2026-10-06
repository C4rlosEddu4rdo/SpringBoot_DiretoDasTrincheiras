package academy.devdojo.primeira_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HeroController{
    private static final List<String> HEROES = List.of("Homem de Ferro","Homem Aranha","Capitão América");

    @GetMapping
    public List<String> listAllHeroes(){
        return HEROES;
    }

    @GetMapping( "filter")
    public List<String> listAllHeroesFilterParam(@RequestParam(required = false) String name){
        return HEROES.stream().filter(hero -> hero.equalsIgnoreCase(name)).toList();
    }
    @GetMapping("filterList")
    public List<String> listAllHeroesFilterParamList(@RequestParam(required = false) List<String> names){
        return names.stream().filter(names::contains).toList();
    }
    @GetMapping("{name}")
    public String findByName(@PathVariable(value = "name") String nome){
        return HEROES.stream().filter(hero -> hero.equalsIgnoreCase(nome)).findFirst().orElse("");
    }

}
