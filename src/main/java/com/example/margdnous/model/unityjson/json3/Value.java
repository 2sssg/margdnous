package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Value {
    private double num;

    public Value(double num) {
        this.num = num;
    }
}
