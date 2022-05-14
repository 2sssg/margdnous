package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class RoMeitems {
    private X x;
    private Y y;
    private Z z;

    public RoMeitems(int x_max, int x_min, int y_max, int y_min , int z_max, int z_min) {
        this.x = new X(x_max, x_min);
        this.y = new Y(y_max, y_min);
        this.z = new Z(z_max, z_min);
    }
}
