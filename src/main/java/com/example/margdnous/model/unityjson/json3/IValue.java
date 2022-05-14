package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class IValue {
    private SamplerOptions samplerOptions ;

    public IValue(int sunAngle_hour) {
        this.samplerOptions = new SamplerOptions(sunAngle_hour,0);
    }
}
