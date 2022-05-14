package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Hueitems {
    private HueOffset hueOffset;

    public Hueitems(int hue_max, int hue_min) {
        hueOffset = new HueOffset(hue_max,hue_min);
    }
}
