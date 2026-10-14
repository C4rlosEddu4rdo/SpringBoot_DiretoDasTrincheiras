package academy.devdojo.primeira_api.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AnimePostRequest {
    private String name;
}
