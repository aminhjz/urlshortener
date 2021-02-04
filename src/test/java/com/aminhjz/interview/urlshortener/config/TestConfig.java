package com.aminhjz.interview.urlshortener.config;

import com.aminhjz.interview.urlshortener.repository.UrlRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public UrlRepository createUrlRepository(){
        return Mockito.mock(UrlRepository.class);
    }
}
