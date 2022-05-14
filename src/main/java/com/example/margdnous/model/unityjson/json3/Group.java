package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Group {
    private BackgroundObjectPlacementRandomizer1 BackgroundObjectPlacementRandomizer = new BackgroundObjectPlacementRandomizer1();
    private HueOffsetRandomizer1 HueOffsetRandomizer;
    private RotationRandomizer1 RotationRandomizer;
    private SunAngleRandomizer1 SunAngleRandomizer;

    public Group(int x_max, int x_min, int y_max, int y_min , int z_max, int z_min, int hue_max, int hue_min, int sunAngle_hour, int sunAngle_doy, int sunAngle_latitude) {
        HueOffsetRandomizer = new HueOffsetRandomizer1(hue_max, hue_min);
        RotationRandomizer = new RotationRandomizer1(x_max, x_min,  y_max, y_min , z_max, z_min);
        SunAngleRandomizer = new SunAngleRandomizer1(sunAngle_hour,sunAngle_doy,  sunAngle_latitude);
    }
}
