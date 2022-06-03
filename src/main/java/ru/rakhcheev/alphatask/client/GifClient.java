package ru.rakhcheev.alphatask.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rakhcheev.alphatask.model.gif.Gif;


@FeignClient(url = "${gifService.url}", name = "${gifService.name}")
public interface GifClient {

    @GetMapping("/random")
    Gif getRandomGifByTag(@RequestParam("api_key") String apiKey,
                          @RequestParam("tag") String tag,
                          @RequestParam("rating") String rating);
}
