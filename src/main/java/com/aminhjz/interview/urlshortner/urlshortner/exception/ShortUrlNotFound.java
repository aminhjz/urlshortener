package com.aminhjz.interview.urlshortner.urlshortner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ShortUrlNotFound extends ResponseStatusException {
    public ShortUrlNotFound(String shortUrl) {
        super(HttpStatus.NOT_FOUND, "Could not find any url related to this short url: "+shortUrl);
    }
}
