package academy.devdojo.primeira_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Anime {
    private Long id;
    private String name;

    public static List<Anime> getAnimes(){
        return new ArrayList<>(List.of(new Anime(1L,"Naruto"),new Anime(2L,"Dragon Ball Z")));
    }

}
