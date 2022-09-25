package com.deutschland.springconceptreplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SpringConceptReplayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringConceptReplayApplication.class, args);
    }

}
