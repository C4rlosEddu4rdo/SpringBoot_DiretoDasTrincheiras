package academy.devdojo.primeira_api.repository;

import academy.devdojo.primeira_api.domain.Anime;
import academy.devdojo.primeira_api.domain.Producer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AnimeRepository {
    private static List<Anime> animes = new ArrayList<>();
    static {
        animes.addAll(List.of(new Anime(1L,"Naruto"),new Anime(2L,"Dragon Ball Z")));
    }

    public List<Anime> listAll() {
        return animes;
    }
    public List<Anime> findByName(String name) {
        return animes.stream().filter(anime -> anime.getName().equalsIgnoreCase(name)).toList();
    }
    public Optional<Anime> findById(Long id) {
        return animes.stream().filter(anime -> anime.getId().equals(id)).findFirst();
    }
    public Anime save(Anime anime) {
        animes.add(anime);
        return anime;
    }
    public void deleteById(Anime anime) {
        animes.remove(anime);
    }
    public void update(Anime anime) {
        deleteById(anime);
        save(anime);
    }
}
