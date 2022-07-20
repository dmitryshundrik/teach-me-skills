package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Scanner;
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "org.example")
public class RootConfiguration {
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }
}
