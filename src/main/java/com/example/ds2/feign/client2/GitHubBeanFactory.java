package com.example.ds2.feign.client2;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.slf4j.Slf4jLogger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Configuration
public class GitHubBeanFactory {

    @Bean
    public GitHubBuilderClient gitHubClient(){
        return Feign.builder()
                .encoder(new GsonEncoder())
                .decoder(new GsonDecoder())
                .logLevel(Logger.Level.FULL)
                .logger(new Slf4jLogger(GitHubBuilderClient.class))
                .options(new Request.Options(10, TimeUnit.SECONDS, 60, TimeUnit.SECONDS, true))
                .target(GitHubBuilderClient.class, "https://api.github.com");
    }

}
