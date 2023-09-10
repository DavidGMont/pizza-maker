package com.pizzability.maker;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EnableJpaAuditing
@Slf4j
public class PizzaMakerApplication {
    public static void main(String[] args) {
        SpringApplication.run(PizzaMakerApplication.class, args);
        LOGGER.info("🍕 Pizzability está abriendo al público...");
    }
}
