package academy.devdojo.primeira_api.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Hero {
    private Long id;
    private String name;
    private String descriptionUltPower;
}
