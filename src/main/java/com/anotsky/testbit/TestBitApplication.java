package com.anotsky.testbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class TestBitApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestBitApplication.class, args);
    }

}
