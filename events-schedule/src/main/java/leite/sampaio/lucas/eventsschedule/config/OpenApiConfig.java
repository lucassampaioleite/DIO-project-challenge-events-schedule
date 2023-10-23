package leite.sampaio.lucas.eventsschedule.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("REST API for Events Schedule with Java 21 and Spring Boot 3.1.5")
                        .version("v1")
                        .description("This API was built for the DIO Code Update TQI Bootcamp project challenge - Backend with Kotlin and Java.")
                );
    }


}
