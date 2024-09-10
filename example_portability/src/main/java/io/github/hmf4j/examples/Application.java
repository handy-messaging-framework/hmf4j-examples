package io.github.hmf4j.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"io.github.handy", "io.github.hmf4j"})
public class Application {
    public static void main(String... args){
        SpringApplication.run(Application.class, args);
    }
}
