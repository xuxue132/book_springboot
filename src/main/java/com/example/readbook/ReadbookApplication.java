package com.example.readbook;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.readbook.Dao")
public class ReadbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadbookApplication.class, args);
    }

}
