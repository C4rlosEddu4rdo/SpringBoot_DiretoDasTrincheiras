package academy.devdojo.primeira_api.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producer {
    private Long id;
    private String name;

    @Getter
    private static List<Producer> producers = new ArrayList<>();
    static {
        producers.addAll(List.of(new Producer(1L,"Dexter"),new Producer(2L,"Dark")));
    }
}
