package io.github.sunshine001.guava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class GuavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuavaApplication.class, args);

        Console.log("cisco", "sailor", 1, 2);
    }

}
