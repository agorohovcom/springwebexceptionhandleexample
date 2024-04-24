package com.agorohov.springwebexceptionhandleexample;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringWebExceptionHandleExampleApplication {
    private static final Logger log = LoggerFactory.getLogger(SpringWebExceptionHandleExampleApplication.class);

    @PostConstruct
    public void run() {
        log.info("Приложение запущено!");
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringWebExceptionHandleExampleApplication.class, args);
    }

}
