package com.aminhjz.interview.urlshortener.repository.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class UrlEntity {

    @Id
    private final String shortUrl;
    private final String url;

    public UrlEntity(String shortUrl, String url) {
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
        return "UrlEntity{" +
                "shortUrl='" + shortUrl + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
