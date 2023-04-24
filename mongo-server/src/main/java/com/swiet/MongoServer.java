package com.swiet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

/**
 * @author DengQiao
 * @Date 2023/4/23
 */
@SpringBootApplication(exclude={MongoAutoConfiguration.class})
public class MongoServer {
    public static void main(String[] args) {
        SpringApplication.run(MongoServer.class, args);
    }
}