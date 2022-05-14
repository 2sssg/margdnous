package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Randomizer {
    private Group groups;

    public Randomizer(int x_max, int x_min, int y_max, int y_min , int z_max, int z_min, int hue_max, int hue_min, int sunAngle_hour, int sunAngle_doy, int sunAngle_latitude) {
        groups = new Group(x_max, x_min,  y_max,  y_min ,  z_max,  z_min,  hue_max,  hue_min,  sunAngle_hour,  sunAngle_doy,  sunAngle_latitude);
    }
}
