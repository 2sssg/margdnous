package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class RotationRandomizer1 {
    private Metadata metadata = new Metadata();
    private Rotaitem items;

    public RotationRandomizer1(int x_max, int x_min, int y_max, int y_min , int z_max, int z_min) {
        items = new Rotaitem(x_max, x_min, y_max, y_min , z_max, z_min);
    }
}
