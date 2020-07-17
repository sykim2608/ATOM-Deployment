package com.example.atom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Application 설정.
 * @author sykim@ntels.com
 */
@SpringBootApplication
public class Application {
    /**
     * Main 메소드
     * @param args 인자
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
