package ru.rakhcheev.alphatask.model.gif;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Gif {

    @JsonProperty("data")
    private GifData data;

    @JsonProperty("meta")
    private GifMeta meta;

}
