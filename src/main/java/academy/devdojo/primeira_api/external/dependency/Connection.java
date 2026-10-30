package academy.devdojo.primeira_api.external.dependency;

import lombok.AllArgsConstructor;
import lombok.ToString;

@ToString
@AllArgsConstructor
public class Connection {
    private String host;
    private String username;
    private String password;
}
