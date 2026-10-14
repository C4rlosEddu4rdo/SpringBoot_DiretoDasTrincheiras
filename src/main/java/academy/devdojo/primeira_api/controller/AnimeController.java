package academy.devdojo.primeira_api.controller;

import academy.devdojo.primeira_api.domain.Anime;
import academy.devdojo.primeira_api.dto.request.AnimePostRequest;
import academy.devdojo.primeira_api.dto.response.AnimeResponse;
import academy.devdojo.primeira_api.mapper.AnimeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "v1/animes")
@RequiredArgsConstructor
public class AnimeController {
    private final AnimeMapper MAPPER;

    @GetMapping
    public ResponseEntity<List<AnimeResponse>> listAllOrFindyByName(@RequestParam (required = false) String name){
        var animes = Anime.getAnimes();
        List<AnimeResponse> animeResponseList = MAPPER.toAnimeResponseList(animes);
        if (name == null) {
            return ResponseEntity.ok(animeResponseList);
        }
        List<AnimeResponse> response = animeResponseList.stream().filter(anime -> anime.getName().equalsIgnoreCase(name)).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<AnimeResponse> findById(@PathVariable Long id){
        AnimeResponse animeResponse = Anime.getAnimes().stream().filter(anime -> anime.getId().equals(id)).findFirst().map(MAPPER::toAnimeResponse).orElse(null);
        return ResponseEntity.ok(animeResponse);
    }
    @PostMapping
    public ResponseEntity<AnimeResponse> save(@RequestBody AnimePostRequest animePostRequest){
        var anime = MAPPER.toAnime(animePostRequest);
        anime.setId(Anime.getAnimes().getLast().getId() + 1);
        Anime.getAnimes().add(anime);
        AnimeResponse animeResponse = MAPPER.toAnimeResponse(anime);
        return ResponseEntity.status(HttpStatus.CREATED).body(animeResponse);
    }



}
