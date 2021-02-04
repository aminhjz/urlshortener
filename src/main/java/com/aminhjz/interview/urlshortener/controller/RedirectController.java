package com.aminhjz.interview.urlshortener.controller;

import com.aminhjz.interview.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/")
public class RedirectController {

    private final UrlService urlService;

    @Autowired
    public RedirectController(UrlService urlService) {
        this.urlService = urlService;
    }

    @GetMapping("{shortUrlKey}")
    public void redirectToUrl(@PathVariable("shortUrlKey") String shortUrlKey, HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Location", urlService.getUrl(shortUrlKey));
        httpServletResponse.setStatus(302);
    }
}
