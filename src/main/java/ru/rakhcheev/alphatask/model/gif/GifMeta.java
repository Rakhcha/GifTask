package ru.rakhcheev.alphatask.model.gif;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GifMeta {

    @JsonProperty("msg")
    private String msg;

    @JsonProperty("status")
    private String status;

    @JsonProperty("response_id")
    private String response_id;

}
