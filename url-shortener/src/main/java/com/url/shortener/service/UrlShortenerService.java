package com.url.shortener.service;


import org.springframework.stereotype.Service;

import com.url.shortener.entity.Url;
import com.url.shortener.repository.UrlRepository;

import java.util.Base64;
import java.util.Optional;

@Service
public class UrlShortenerService {

    private final UrlRepository urlRepository;

    public UrlShortenerService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public String shortenUrl(String originalUrl) {
        Optional<Url> existingUrl = urlRepository.findByOriginalUrl(originalUrl);
        if (existingUrl.isPresent()) {
            return existingUrl.get().getShortUrl();
        }

        String shortUrl = Base64.getUrlEncoder()
                .encodeToString(originalUrl.getBytes())
                .substring(0, 8); // Shorten the URL

        Url url = new Url(originalUrl, shortUrl);
        urlRepository.save(url);

        return shortUrl;
    }

    public String getOriginalUrl(String shortUrl) throws Exception {
        return urlRepository.findByShortUrl(shortUrl)
                .orElseThrow(() -> new Exception("URL not found"))
                .getOriginalUrl();
    }
}

