package com.example.margdnous.model.unityjson.json2;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Color {
    private double r;
    private double g;
    private double b;
    private int a;

    public Color() {
        this.r = Math.random();
        this.g = Math.random();
        this.b = Math.random();
        this.a = 1;
    }
}
