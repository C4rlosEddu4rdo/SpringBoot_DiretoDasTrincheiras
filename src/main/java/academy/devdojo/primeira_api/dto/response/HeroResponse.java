package academy.devdojo.primeira_api.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroResponse {
    private Long id;
    private String name;
    private String descriptionUltPower;
}
