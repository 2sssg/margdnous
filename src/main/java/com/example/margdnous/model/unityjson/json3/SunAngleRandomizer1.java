package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class SunAngleRandomizer1 {
    private Metadata metadata = new Metadata();
    private Sunitem items;

    public SunAngleRandomizer1(int sunAngle_hour, int sunAngle_doy, int sunAngle_latitude) {
        items = new Sunitem(sunAngle_hour, sunAngle_doy, sunAngle_latitude);
    }
}
