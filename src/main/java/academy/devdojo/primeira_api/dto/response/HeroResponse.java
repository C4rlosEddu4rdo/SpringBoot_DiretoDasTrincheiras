package academy.devdojo.primeira_api.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"id", "name", "descriptionUltPower"})
public class HeroResponse {
    private Long id;
    private String name;
    private String descriptionUltPower;
}
