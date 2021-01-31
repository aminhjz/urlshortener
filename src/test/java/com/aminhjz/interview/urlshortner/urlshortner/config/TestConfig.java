package com.aminhjz.interview.urlshortner.urlshortner.config;

import com.aminhjz.interview.urlshortner.urlshortner.repository.UrlRepository;
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
