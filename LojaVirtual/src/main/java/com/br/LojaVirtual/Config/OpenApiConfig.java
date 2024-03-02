package com.br.LojaVirtual.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;


@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API da Loja Virtual")
                        .description("Api desenvolvida a fins de estudos.")
                        .version("1.0.0")
                        .termsOfService("")
                        .contact(new io.swagger.v3.oas.models.info.Contact()
                                .name("")
                                .email("")
                                .url(""))
                        .license(new io.swagger.v3.oas.models.info.License()
                                .name("")
                                .url("")));
    }


}
