package pl_tecna_data_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("!stage & !prod")
class OpenApiConfig {

    private static final String VERSION = "v0.0.1";

    private static final String API_TITLE = "DATA SERVICE API";

    @Bean
    public OpenAPI dataServiceOpenAPI(){
        return new OpenAPI()
                .info(createInfo());
    }

    private Info createInfo(){
        return new Info()
                .title(API_TITLE)
                .version(VERSION);
    }
}
