package ru.pavel2107.arch.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CatalogServiceStarter {

    public static void main(String[] args) {
        SpringApplication.run( CatalogServiceStarter.class, args);
    }
}
