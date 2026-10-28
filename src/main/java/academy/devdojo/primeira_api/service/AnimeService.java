package academy.devdojo.primeira_api.service;

import academy.devdojo.primeira_api.domain.Anime;
import academy.devdojo.primeira_api.repository.AnimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnimeService {
    private final AnimeRepository animeRepository;

    public List<Anime> findAll(String name) {
        return name == null ? animeRepository.listAll() : animeRepository.findByName(name);
    }
    public Anime findByIdOrElseThrow(Long id) {
        return animeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID not exists"));
    }
    public Anime save (Anime anime){
        return animeRepository.save(anime);
    }

    public void deleteById(Anime anime) {
        Anime animeById = findByIdOrElseThrow(anime.getId());
        animeRepository.deleteById(animeById);
    }
    public void update(Anime anime){
        Anime animeUpdate = findByIdOrElseThrow(anime.getId());
        animeRepository.save(animeUpdate);
    }

}
