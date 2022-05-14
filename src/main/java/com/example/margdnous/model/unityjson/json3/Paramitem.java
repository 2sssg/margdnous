package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Paramitem {
    private Paramvalue value;

    public Paramitem(int hue_max, int hue_min) {
        value = new Paramvalue(hue_max, hue_min);
    }
}
