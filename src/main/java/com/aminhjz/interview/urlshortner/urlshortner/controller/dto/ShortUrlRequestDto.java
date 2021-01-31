package com.aminhjz.interview.urlshortner.urlshortner.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortUrlRequestDto {
    private final String url;

    @JsonCreator
    public ShortUrlRequestDto(@JsonProperty("url") String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "ShortUrlRequestDto{" +
                "url='" + url + '\'' +
                '}';
    }
}
