package com.example.ds2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class Ds2Application {

  public static void main(String[] args) {
    SpringApplication.run(Ds2Application.class, args);
  }

}

