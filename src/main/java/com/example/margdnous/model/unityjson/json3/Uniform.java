package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Uniform {
    private double min;
    private double max;

    public Uniform(double min, double max) {
        this.min = min;
        this.max = max;
    }
}
