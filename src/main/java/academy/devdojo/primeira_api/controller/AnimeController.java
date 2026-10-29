package academy.devdojo.primeira_api.controller;

import academy.devdojo.primeira_api.domain.Anime;
import academy.devdojo.primeira_api.dto.request.AnimePostRequest;
import academy.devdojo.primeira_api.dto.request.AnimePutRequest;
import academy.devdojo.primeira_api.dto.response.AnimeResponse;
import academy.devdojo.primeira_api.mapper.AnimeMapper;
import academy.devdojo.primeira_api.repository.AnimeRepository;
import academy.devdojo.primeira_api.service.AnimeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Log4j2
@RestController
@RequestMapping(value = "v1/animes")
@RequiredArgsConstructor
public class AnimeController {
    private final AnimeMapper MAPPER;
    private final AnimeService service;

    @GetMapping
    public ResponseEntity<List<AnimeResponse>> listAllOrFindByName(@RequestParam(required = false) String name){
        log.debug("solicitação recebida para listar todos os animes, nome do parâmetro {}",name);
        var anime = service.findAll(name);

        var animeResponseList = MAPPER.toAnimeResponseList(anime);

        return ResponseEntity.ok(animeResponseList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnimeResponse> getAnimeById(@PathVariable Long id){
        log.debug("solicitação recebida para encontrar anime por ID {}",id);
        Anime anime = service.findByIdOrElseThrow(id);
        AnimeResponse animeResponse = MAPPER.toAnimeResponse(anime);
        return ResponseEntity.ok(animeResponse);
    }

    @PostMapping
    public ResponseEntity<AnimeResponse> addAnime(@RequestBody AnimePostRequest animePostRequest){
        log.debug("solicitação para salvar anime {}", animePostRequest);
        Anime anime = MAPPER.toAnime(animePostRequest);
        Anime animeSaved = service.save(anime);
        AnimeResponse animeResponse = MAPPER.toAnimeResponse(animeSaved);
        return ResponseEntity.status(HttpStatus.CREATED).body(animeResponse);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteAnime(@PathVariable Long id){
        log.debug("deletar anime por ID {}",id);
        service.deleteById(id);
        return ResponseEntity.noContent().build();

    }
    @PutMapping
    public ResponseEntity<Void> updateAnime(@RequestBody AnimePutRequest request){
        log.debug("atualizando anime {}",request);
        Anime anime = MAPPER.toAnime(request);
        service.update(anime);
        return ResponseEntity.noContent().build();

    }

}
