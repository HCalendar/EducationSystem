package org.example.educationsystembackend;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.educationsystembackend.mapper")
public class EducationSystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EducationSystemBackendApplication.class, args);
    }

}
