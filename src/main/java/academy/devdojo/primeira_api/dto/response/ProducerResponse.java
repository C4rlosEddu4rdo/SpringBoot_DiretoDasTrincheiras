package academy.devdojo.primeira_api.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
public class ProducerResponse {
    private String name;
    private LocalDateTime createdAt;
}
