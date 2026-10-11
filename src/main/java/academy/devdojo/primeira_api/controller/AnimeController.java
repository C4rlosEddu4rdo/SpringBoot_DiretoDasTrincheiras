package academy.devdojo.primeira_api.controller;

import academy.devdojo.primeira_api.domain.Anime;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "v1/animes")
public class AnimeController {

    @GetMapping
    public List<Anime> listAllOrFindyByName(@RequestParam (required = false) String name){
        var animes = Anime.getAnimes();
        if (name == null) return animes;
        return animes.stream().filter(anime -> anime.getName().equalsIgnoreCase(name)).toList();
    }

    @GetMapping("{id}")
    public Anime findById(@PathVariable Long id){
        return Anime.getAnimes().stream().filter(anime -> anime.getId().equals(id)).findFirst().orElse(null);
    }
    @PostMapping
    public Anime save(@RequestBody Anime anime){
        anime.setId(Anime.getAnimes().getLast().getId() + 1);
        Anime.getAnimes().add(anime);
        return anime;
    }



}
