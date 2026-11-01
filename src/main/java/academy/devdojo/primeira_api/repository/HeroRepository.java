package academy.devdojo.primeira_api.repository;

import academy.devdojo.primeira_api.domain.Hero;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
public class HeroRepository {
    private static final List<Hero> heroes = new ArrayList<>();

    static {
        Hero stu = new Hero(2L,"Stu","Avanço com rastro de fogo");
        heroes.addAll(List.of(new Hero(1L,"Piper","Deixar bombas ao pular de paraquedas"),stu));
    }

    public List<Hero> ListAll() {
        return heroes.stream().sorted(Comparator.comparing(Hero::getId)).toList();
    }
    public List<Hero> findByName(String name){
        return heroes.stream().filter(h -> h.getName().equals(name)).toList();
    }
    public Optional<Hero> findById(Long id){
        return heroes.stream().filter(h -> h.getId().equals(id)).findFirst();
    }
    public Hero save(Hero hero){
        var heroId = heroes.stream().mapToLong(Hero::getId).max().orElse(0L) + 1;
        hero.setId(heroId);
        heroes.add(hero);
        return hero;
    }
    public void delete(Hero hero){
        heroes.remove(hero);
    }
    public void update(Hero hero){
        heroes.stream().filter(h -> h.getId().equals(hero.getId())).findFirst().ifPresent(heroes::remove);
        heroes.add(hero);
    }




}
