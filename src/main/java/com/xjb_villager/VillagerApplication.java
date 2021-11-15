package com.xjb_villager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableAsync
public class VillagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(VillagerApplication.class, args);
    }

}
