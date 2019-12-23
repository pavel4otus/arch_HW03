package ru.pavel2107.arch.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class JwtAuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthorizationServerApplication.class, args);
    }

}
