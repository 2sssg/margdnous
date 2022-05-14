package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Latitude {
    private SunParam param;

    public Latitude(int sunAngle_latitude) {
        this.param = new SunParam(sunAngle_latitude);
    }
}
