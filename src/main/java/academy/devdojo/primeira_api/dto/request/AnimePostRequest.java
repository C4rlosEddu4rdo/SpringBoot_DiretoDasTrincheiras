package academy.devdojo.primeira_api.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class AnimePostRequest {
    private String name;
}
