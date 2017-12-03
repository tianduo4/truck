package com.td.truck.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.td.truck")
public class TruckAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(TruckAdminApplication.class, args);
    }
}
