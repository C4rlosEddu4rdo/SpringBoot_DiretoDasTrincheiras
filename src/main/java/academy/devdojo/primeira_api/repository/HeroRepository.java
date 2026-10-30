package academy.devdojo.primeira_api.repository;

import academy.devdojo.primeira_api.domain.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class HeroRepository {
    private static List<Hero> heroes = new ArrayList<>();

    static {
        Hero piper = new Hero(1L,"Piper","Deixar bombas ao pular de paraquedas");
        Hero stu = new Hero(2L,"Stu","Avanço com rastro de fogo");
        heroes.addAll(List.of(piper,stu));
    }

    public List<Hero> ListAll() {
        return heroes;
    }
    public List<Hero> findByName(String name){
        return heroes.stream().filter(h -> h.getName().equals(name)).toList();
    }
    public Optional<Hero> findById(Long id){
        return heroes.stream().filter(h -> h.getId().equals(id)).findFirst();
    }
    public Hero save(Hero hero){
        heroes.add(hero);
        return hero;
    }
    public void delete(Hero hero){
        heroes.remove(hero);
    }
    public void update(Hero hero){
        delete(hero);
        heroes.add(hero);
    }




}
