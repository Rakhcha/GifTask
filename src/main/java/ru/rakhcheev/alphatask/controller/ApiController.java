package ru.rakhcheev.alphatask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rakhcheev.alphatask.model.gif.Gif;
import ru.rakhcheev.alphatask.service.GifService;
import ru.rakhcheev.alphatask.service.RateService;

@RestController
@RequestMapping("api/v1")
public class ApiController {

    private final GifService gifService;
    private final RateService rateService;

    @Autowired
    public ApiController(GifService gifService, RateService rateService) {
        this.gifService = gifService;
        this.rateService = rateService;
    }

    @GetMapping("/statusGif")
    public Gif getGifByRate(@RequestParam(defaultValue = "RUB") String rateCode){
        double nowRate = rateService.getLatestRate(rateCode).getRates().get(rateCode);
        double previousRate = rateService.getPreviousRate(rateCode).getRates().get(rateCode);
        return nowRate > previousRate
                ? gifService.getRandomGifByTag("rich")
                : gifService.getRandomGifByTag("broke");
    }


}
