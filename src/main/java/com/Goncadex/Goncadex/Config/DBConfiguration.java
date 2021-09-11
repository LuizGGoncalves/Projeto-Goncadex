package com.Goncadex.Goncadex.Config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {
    private String url;
    private String username;
    private String password;

    @Profile("prod")
    @Bean
    public void testDatabaseConnection(){
        System.out.println("Db connection for Prod - MySQL");
        System.out.println(url);
        System.out.println(username);

    }
}

