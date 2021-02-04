package com.aminhjz.interview.urlshortener.service;

import com.aminhjz.interview.urlshortener.exception.ShortUrlNotFound;
import com.aminhjz.interview.urlshortener.repository.UrlRepository;
import com.aminhjz.interview.urlshortener.repository.entity.UrlEntity;
import com.aminhjz.interview.urlshortener.utils.Base62Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final IdGeneratorService idGeneratorService;

    @Autowired
    public UrlService(UrlRepository urlRepository,
                      IdGeneratorService idGeneratorService) {
        this.urlRepository = urlRepository;
        this.idGeneratorService = idGeneratorService;
    }

    public String createShortUrl(String url) {
        final Long id = idGeneratorService.generateId();
        final String base62Id = Base62Utils.to(id);
        UrlEntity urlEntity = urlRepository.save(new UrlEntity(base62Id, url));
        return urlEntity.getShortUrl();
    }
    public String getUrl(String shortUrl) {
        Optional<UrlEntity> byId = urlRepository.findById(shortUrl);
        if (byId.isPresent()) {
            return byId.get().getUrl();
        }
        throw new ShortUrlNotFound(shortUrl);
    }
}
