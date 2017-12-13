package com.kinopoisk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Created by Maksim Shkurko on 12/7/2017
 *
 * @author m.shkurko
 */

@SpringBootApplication
@EnableJpaAuditing
public class ActorServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ActorServiceApplication.class, args);
    }
}
