package ru.rakhcheev.alphatask.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.rakhcheev.alphatask.client.RateClient;
import ru.rakhcheev.alphatask.model.rate.Rate;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;


@Service
public class RateService {

    private final RateClient client;

    @Value("${rateService.appID}")
    private String APP_ID;

    @Value("${rateService.base}")
    public String BASE_RATE;

    @Autowired
    public RateService(RateClient client) {
        this.client = client;
    }

    public Rate getLatestRate(String rateCode) {
        return client.getLatestRate(APP_ID, BASE_RATE, rateCode);
    }

    public Rate getPreviousRate(String rateCode) {
        String date = LocalDate.now().minusDays(1)
                .format(new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd").toFormatter());
        return client.getPreviousRate(date, APP_ID, BASE_RATE, rateCode);
    }



}
