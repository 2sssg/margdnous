package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Sunitem {
    private Hour hour;
    private DayOfTheYear dayOfTheYear;
    private Latitude latitude;

    public Sunitem(int sunAngle_hour, int sunAngle_doy, int sunAngle_latitude) {
        this.hour = new Hour(sunAngle_hour);
        this.dayOfTheYear = new DayOfTheYear(sunAngle_doy);
        this.latitude = new Latitude(sunAngle_latitude);

    }
}
