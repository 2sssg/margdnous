package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class HueOffsetRandomizer1 {
    private Metadata metadata = new Metadata();
    private Hueitems items;

    public HueOffsetRandomizer1(int hue_max, int hue_min) {
        items = new Hueitems(hue_max, hue_min);
    }
}
