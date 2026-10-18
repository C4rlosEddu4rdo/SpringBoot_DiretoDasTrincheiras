package academy.devdojo.primeira_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Anime {
    private Long id;
    private String name;


    @Getter
    private static List<Anime> animes = new ArrayList<>();
    static {
        animes.addAll(List.of(new Anime(1L,"Naruto"),new Anime(2L,"Dragon Ball Z")));
    }
}
