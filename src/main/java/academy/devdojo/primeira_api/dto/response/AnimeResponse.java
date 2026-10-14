package academy.devdojo.primeira_api.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AnimeResponse {
    private Long id;
    private String name;
}
