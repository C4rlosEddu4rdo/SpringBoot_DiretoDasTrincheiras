package academy.devdojo.primeira_api.domain;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
public class Producer {
    private Long id;
    private String name;
    private LocalDateTime createdAt;


    @Getter
    private static List<Producer> producers = new ArrayList<>();
    static {
        producers.addAll(List.of(Producer.builder().id(1L).name("Dexter").createdAt(LocalDateTime.now()).build(),
                (Producer.builder().id(2L).name("Dark").createdAt(LocalDateTime.now()).build())));
    }
}
