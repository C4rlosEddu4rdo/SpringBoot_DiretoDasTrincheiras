package academy.devdojo.primeira_api.data;

import academy.devdojo.primeira_api.domain.Hero;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HeroData {
    private static List<Hero> heroes = new ArrayList<>();

    static {
        Hero stu = new Hero(2L,"Stu","Avanço com rastro de fogo");
        heroes.addAll(List.of(new Hero(1L,"Piper","Deixar bombas ao pular de paraquedas"),stu));
    }

    public List<Hero> getHeroes() {
        return heroes;
    }
}
