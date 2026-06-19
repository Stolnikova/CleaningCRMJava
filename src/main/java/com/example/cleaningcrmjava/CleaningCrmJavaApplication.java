package com.example.cleaningcrmjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class CleaningCrmJavaApplication {

    public static void main(String[] args) {

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        SpringApplication.run(CleaningCrmJavaApplication.class, args);
    }

}
