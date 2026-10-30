package academy.devdojo.primeira_api.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HeroPostRequest {
    private String name;
    private String descriptionUltPower;
}
