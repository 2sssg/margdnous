package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class DayOfTheYear {
    private SunParam param;

    public DayOfTheYear(int sunAngle_doy) {
        this.param = new SunParam(sunAngle_doy);
    }
}
