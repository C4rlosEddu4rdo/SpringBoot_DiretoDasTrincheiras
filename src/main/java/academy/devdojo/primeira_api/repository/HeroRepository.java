package academy.devdojo.primeira_api.repository;

import academy.devdojo.primeira_api.data.HeroData;
import academy.devdojo.primeira_api.domain.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class HeroRepository {
    private final HeroData heroData;

    public List<Hero> listAll() {
        return heroData.getHeroes().stream().sorted(Comparator.comparing(Hero::getId)).toList();
    }
    public List<Hero> findByName(String name){
        return heroData.getHeroes().stream().filter(h -> h.getName().equals(name)).toList();
    }
    public Optional<Hero> findById(Long id){
        return heroData.getHeroes().stream().filter(h -> h.getId().equals(id)).findFirst();
    }
    public Hero save(Hero hero){
        var heroId = heroData.getHeroes().stream().mapToLong(Hero::getId).max().orElse(0L) + 1;
        hero.setId(heroId);
        heroData.getHeroes().add(hero);
        return hero;
    }
    public void delete(Hero hero){
        heroData.getHeroes().remove(hero);
    }
    public void update(Hero hero){
        heroData.getHeroes().stream().filter(h -> h.getId().equals(hero.getId())).findFirst().ifPresent(heroData.getHeroes()::remove);
        heroData.getHeroes().add(hero);
    }




}
