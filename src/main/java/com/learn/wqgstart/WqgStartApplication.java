package com.learn.wqgstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com/learn/wqgstart/mapper")
public class WqgStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(WqgStartApplication.class, args);
    }

}
