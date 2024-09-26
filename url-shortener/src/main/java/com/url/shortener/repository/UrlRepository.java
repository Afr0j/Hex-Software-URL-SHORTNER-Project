package com.url.shortener.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.url.shortener.entity.Url;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByShortUrl(String shortUrl);
    Optional<Url> findByOriginalUrl(String originalUrl);
}

