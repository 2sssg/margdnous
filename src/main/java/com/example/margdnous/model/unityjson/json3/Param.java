package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Param {
    private Metadata metadata = new Metadata();
    private Paramitem items;

    public Param(int hue_max, int hue_min) {
        items = new Paramitem(hue_max, hue_min);
    }
}
