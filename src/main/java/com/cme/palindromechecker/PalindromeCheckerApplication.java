package com.cme.palindromechecker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class PalindromeCheckerApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalindromeCheckerApplication.class, args);
    }
}
