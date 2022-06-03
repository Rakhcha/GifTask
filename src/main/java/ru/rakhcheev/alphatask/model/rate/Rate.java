package ru.rakhcheev.alphatask.model.rate;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

@Data
public class Rate {

    @JsonProperty("timestamp")
    private Integer timestamp;

    @JsonProperty("base")
    private String base;

    @JsonProperty("rates")
    private Map<String,Double> rates;


}
