package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Scalar {
    private Metadata metadata = new Metadata();
    private Value value;

    public Scalar(double num) {
        value = new Value(num);
    }
}
