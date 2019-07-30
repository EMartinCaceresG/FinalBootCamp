package com.everis.bootcamp.ejecicio01maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
public class Ejecicio01mavenApplication implements CommandLineRunner {

    @Autowired
    AppConfigBean appConfigBean;

    public static void main(String[] args) {
        SpringApplication.run(Ejecicio01mavenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(appConfigBean.getDb_url() + " user:" + appConfigBean.getDb_username() + " platform:" + appConfigBean.getDb_platform());
    }
}

