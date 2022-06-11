package co.edu.ufps.ingsistemas.sjcr.storeservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringShopOpenAPI {

    @Bean
    public OpenAPI openAPIConfig() {
        return new OpenAPI().info(apiInfo());
    }

    public Info apiInfo() {
        return new Info()
                .title("Store Service")
                .description("Store Service")
                .version("v1.0.0")
                .license(new License()
                        .name("Apache License, Version 2.0")
                        .url("https://www.apache.org/licenses/LICENSE-2.0"))
                .contact(new Contact()
                        .name("STIWARD JHERIKOF CARRILLO RAMIREZ")
                        .url("https://stiwardjherikofcr.github.io/")
                        .email("stiwardjherikofcr@ufps.edu.co"))
                .termsOfService("https://www.ufps.edu.co/");
    }

}

