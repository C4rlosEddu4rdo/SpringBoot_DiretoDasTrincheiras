package academy.devdojo.primeira_api.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnimePutRequest {
    private Long id;
    private String name;
}
