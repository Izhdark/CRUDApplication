package com.process.PersonManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * Created by Кирилл on 08.02.2017.
 */
@SpringBootApplication
@EnableOAuth2Sso
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}
