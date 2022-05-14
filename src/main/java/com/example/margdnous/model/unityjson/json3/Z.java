package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Z {
    private SamplerOptions samplerOptions;

    public Z(int max, int min) {
        this.samplerOptions = new SamplerOptions(max,min);
    }
}
