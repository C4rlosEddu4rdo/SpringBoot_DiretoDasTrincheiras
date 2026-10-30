package academy.devdojo.primeira_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Hero {
    private Long id;
    private String name;
    private String descriptionUltPower;
}
