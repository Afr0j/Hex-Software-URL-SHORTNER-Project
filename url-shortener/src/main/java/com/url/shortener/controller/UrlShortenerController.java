package com.url.shortener.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.url.shortener.service.UrlShortenerService;

@Controller
public class UrlShortenerController {

    private final UrlShortenerService urlShortenerService;

    public UrlShortenerController(UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @PostMapping("/shorten")
    public String shortenUrl(@RequestParam String url, Model model) {
        String shortUrl = urlShortenerService.shortenUrl(url);
        model.addAttribute("shortUrl", shortUrl);
        return "result";
    }

    @GetMapping("/{shortUrl}")
    public String redirectToOriginal(@PathVariable String shortUrl) throws Exception {
        String originalUrl = urlShortenerService.getOriginalUrl(shortUrl);
        return "redirect:" + originalUrl;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
}

