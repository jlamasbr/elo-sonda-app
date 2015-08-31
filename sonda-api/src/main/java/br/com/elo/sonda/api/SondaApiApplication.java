package br.com.elo.sonda.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="br.com.elo")
public class SondaApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SondaApiApplication.class, args);
    }
}
