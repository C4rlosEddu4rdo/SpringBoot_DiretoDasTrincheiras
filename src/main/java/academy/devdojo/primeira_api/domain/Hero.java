package academy.devdojo.primeira_api.domain;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Hero {
    private Long id;
    private String name;
    private String descriptionUltPower;
}
