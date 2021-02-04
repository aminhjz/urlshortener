package com.aminhjz.interview.urlshortener.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortUrlPairDto {
    private final String shortUrl;
    private final String url;

    @JsonCreator
    public ShortUrlPairDto(@JsonProperty("shortUrl") String shortUrl,
                           @JsonProperty("url") String url) {
        this.shortUrl = shortUrl;
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "ShortUrlPairDto{" +
                "shortUrl='" + shortUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
