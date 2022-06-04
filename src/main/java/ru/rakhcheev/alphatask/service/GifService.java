package ru.rakhcheev.alphatask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.rakhcheev.alphatask.client.GifClient;
import ru.rakhcheev.alphatask.model.gif.Gif;

@Service
public class GifService {

    private final GifClient client;

    @Value("${gifService.api_key}")
    private String API_KEY;

    @Value("${gifService.rating}")
    private String RATING;

    @Autowired
    public GifService(GifClient client) {
        this.client = client;
    }

    public Gif getRandomGifByTag(String tag){
        return client.getRandomGifByTag(API_KEY,tag,RATING);
    }

}
