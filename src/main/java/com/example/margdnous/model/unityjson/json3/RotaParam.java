package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class RotaParam {
    private Metadata metadata = new Metadata();
    private RoMeitems items;

    public RotaParam(int x_max, int x_min, int y_max, int y_min , int z_max, int z_min) {
        this.items = new RoMeitems(x_max, x_min, y_max, y_min , z_max,  z_min);
    }
}
