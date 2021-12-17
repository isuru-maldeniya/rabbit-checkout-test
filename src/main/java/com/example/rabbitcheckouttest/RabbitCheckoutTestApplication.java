package com.example.rabbitcheckouttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class RabbitCheckoutTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitCheckoutTestApplication.class, args);
    }

}
