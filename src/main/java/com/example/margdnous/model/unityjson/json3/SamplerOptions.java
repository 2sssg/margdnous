package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class SamplerOptions {
    private Metadata metadata = new Metadata();
    private Uniform uniform;

    public SamplerOptions(int hue_max, int hue_min) {
        uniform = new Uniform(hue_min, hue_max);
    }
}
