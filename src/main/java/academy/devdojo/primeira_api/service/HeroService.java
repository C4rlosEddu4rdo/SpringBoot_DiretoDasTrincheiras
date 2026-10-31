package academy.devdojo.primeira_api.service;

import academy.devdojo.primeira_api.domain.Hero;
import academy.devdojo.primeira_api.repository.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroService {
    private final HeroRepository heroRepository;

    public List<Hero> listAllOrFindByName (String name){
        return name == null ? heroRepository.ListAll() : heroRepository.findByName(name);
    }
    public Hero findByIdOrElseThrow(Long id){
        return heroRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id not found"));
    }
    public Hero save(Hero hero){

        return heroRepository.save(hero);
    }
    public void delete (Long id){
        Hero heroById = findByIdOrElseThrow(id);
        heroRepository.delete(heroById);
    }
    public void update (Hero hero){
        Hero heroUpdate = findByIdOrElseThrow(hero.getId());
        heroRepository.update(heroUpdate);
    }


}
