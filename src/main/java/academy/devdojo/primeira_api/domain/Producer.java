package academy.devdojo.primeira_api.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
public class Producer {
    private Long id;
    private String name;
    private LocalDateTime createdAt;

}
