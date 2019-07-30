package com.everis.bootcamp.ejecicio02maven;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ejecicio02mavenApplication implements CommandLineRunner {

    @Autowired
    AppConfigBean appConfigBean;

    public static void main(String[] args) {
        SpringApplication.run(Ejecicio02mavenApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(appConfigBean.getDb_url() + " user:" + appConfigBean.getDb_username() + " platform:" + appConfigBean.getDb_platform());
    }
}

