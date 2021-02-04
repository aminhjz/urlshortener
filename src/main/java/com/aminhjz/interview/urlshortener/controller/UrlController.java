package com.aminhjz.interview.urlshortener.controller;

import com.aminhjz.interview.urlshortener.controller.dto.ShortUrlPairDto;
import com.aminhjz.interview.urlshortener.controller.dto.ShortUrlRequestDto;
import com.aminhjz.interview.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/1/urls")
public class UrlController {

    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<ShortUrlPairDto> createShortUrl(@RequestBody ShortUrlRequestDto shortUrlRequestDto){
        final String shortUrl = urlService.createShortUrl(shortUrlRequestDto.getUrl());
        final ShortUrlPairDto body = new ShortUrlPairDto(shortUrl, shortUrlRequestDto.getUrl());
        return ResponseEntity.status(HttpStatus.CREATED).body(body);
    }

    @GetMapping(value = "{shortUrl}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ShortUrlPairDto> getUrl(@PathVariable("shortUrl") String shortUrl){
        return ResponseEntity.ok(new ShortUrlPairDto( shortUrl, urlService.getUrl(shortUrl)));
    }
}
