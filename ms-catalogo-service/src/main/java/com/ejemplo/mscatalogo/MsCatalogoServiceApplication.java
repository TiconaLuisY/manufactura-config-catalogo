package com.ejemplo.mscatalogo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "API Catálogo",
        version = "1.0",
        description = "Microservicio de catálogo"
))
public class MsCatalogoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsCatalogoServiceApplication.class, args);
    }
}

