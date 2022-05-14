package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Hour {
    private SunParam param;

    public Hour(int sunAngle_hour) {
        this.param = new SunParam(sunAngle_hour);
    }
}
