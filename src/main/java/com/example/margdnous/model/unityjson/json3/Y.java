package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Y {
    private SamplerOptions samplerOptions;

    public Y(int max, int min) {
        this.samplerOptions = new SamplerOptions(max,min);
    }
}
