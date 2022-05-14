package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Paramvalue {
    private SamplerOptions samplerOptions;

    public Paramvalue(int hue_max, int hue_min) {
        samplerOptions = new SamplerOptions(hue_max, hue_min);
    }
}
