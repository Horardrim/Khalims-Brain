package com.horadrim.khalims.brain.api.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor 
public class Message {
    @JsonProperty("source")
    private String source_;

    @JsonProperty("timestamp")
    private long timestamp_;
}
