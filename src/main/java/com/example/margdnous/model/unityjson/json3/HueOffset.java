package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class HueOffset {
    private Param param;

    public HueOffset(int hue_max, int hue_min) {
        param = new Param(hue_max, hue_min);
    }
}
