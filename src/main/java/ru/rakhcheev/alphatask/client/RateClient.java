package ru.rakhcheev.alphatask.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.rakhcheev.alphatask.model.rate.Rate;

@FeignClient(url = "${rateService.url}", name = "${rateService.name}")
public interface RateClient {

    @GetMapping("/latest.json")
    Rate getLatestRate(@RequestParam("app_id") String appID,
                       @RequestParam("base") String baseRate,
                       @RequestParam("symbols") String rateCode);


    @GetMapping("/historical/{date}.json")
    Rate getPreviousRate(@PathVariable String date,
                         @RequestParam("app_id") String appID,
                         @RequestParam("base") String baseRate,
                         @RequestParam("symbols") String rateCode);

}
