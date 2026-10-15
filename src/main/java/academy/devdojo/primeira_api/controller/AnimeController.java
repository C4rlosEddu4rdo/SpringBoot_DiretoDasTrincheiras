package academy.devdojo.primeira_api.controller;

import academy.devdojo.primeira_api.domain.Anime;
import academy.devdojo.primeira_api.dto.request.AnimePostRequest;
import academy.devdojo.primeira_api.dto.response.AnimeResponse;
import academy.devdojo.primeira_api.mapper.AnimeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "v1/animes")
@RequiredArgsConstructor
public class AnimeController {
    private final AnimeMapper MAPPER;

    @GetMapping
    public ResponseEntity<List<AnimeResponse>> listAllOrFindByName(@RequestParam(required = false) String name){
        log.debug("solicitação recebida para listar todos os animes, nome do parâmetro {}",name);
        var animes = Anime.getAnimes();
        var animeResponseList = MAPPER.toAnimeResponseList(animes);
        if (name == null) {
            return ResponseEntity.ok(animeResponseList);
        }
        var animeResponse = animeResponseList.stream().filter(anime -> anime.getName().equalsIgnoreCase(name)).toList();
        return ResponseEntity.ok(animeResponse);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnimeResponse> getAnimeById(@PathVariable Long id){
        log.debug("solicitação recebida para encontrar anime por ID {}",id);
        var animeResponse = Anime.getAnimes().stream().filter(anime -> anime.getId().equals(id)).findFirst().map(MAPPER::toAnimeResponse).orElse(null);
        return ResponseEntity.ok(animeResponse);
    }

    @PostMapping
    public ResponseEntity<AnimeResponse> addAnime(@RequestBody AnimePostRequest animePostRequest){
        log.debug("solicitação para salvar anime {}", animePostRequest);
        Anime anime = MAPPER.toAnime(animePostRequest);
        Anime.getAnimes().add(anime);
        AnimeResponse animeResponse = MAPPER.toAnimeResponse(anime);
        return ResponseEntity.status(HttpStatus.CREATED).body(animeResponse);
    }

}
