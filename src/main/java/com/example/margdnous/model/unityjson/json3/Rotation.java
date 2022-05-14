package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Rotation {
    private RotaParam param;

    public Rotation(int x_max, int x_min, int y_max, int y_min , int z_max, int z_min) {
        this.param = new RotaParam(x_max, x_min, y_max, y_min , z_max, z_min);
    }
}
