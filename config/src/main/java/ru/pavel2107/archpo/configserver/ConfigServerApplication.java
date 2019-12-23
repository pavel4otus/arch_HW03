package ru.pavel2107.archpo.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }


    @Bean
    public WebSecurityConfigurerAdapter configurerAdapter(ServerProperties serverProperties){
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(HttpSecurity httpSecurity) throws Exception {
                super.configure( httpSecurity);
                httpSecurity.authorizeRequests()
                        .antMatchers( "**/decrypt/**")
                        .authenticated().and().csrf().disable();

                httpSecurity.authorizeRequests()
                        .antMatchers( "**/encrypt/**")
                        .authenticated().and().csrf().disable();

                System.out.println( "configured");
            }
        };
    }
}