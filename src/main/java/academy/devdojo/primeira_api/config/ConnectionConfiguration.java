package academy.devdojo.primeira_api.config;

import academy.devdojo.primeira_api.external.dependency.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConnectionConfiguration {

    @Bean(name = "connection2")
    public Connection connection(){
        return new Connection("LocalHost","Carlos","9821");
    }
    @Bean
    public Connection connectionMySQL(){
        return new Connection("LocalHostMYSQL","Carlos","9821");
    }

}
