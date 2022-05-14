package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class X {
    private SamplerOptions samplerOptions;

    public X(int max, int min) {
        this.samplerOptions = new SamplerOptions(max, min);
    }
}
