package academy.devdojo.primeira_api.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class HeroPutRequest {
    private Long id;
    private String name;
    private String descriptionUltPower;
}
