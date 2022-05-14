package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class SunParam {
    private Metadata metadata = new Metadata();
    private IItem items ;

    public SunParam(int sunAngle_hour) {
        this.items = new IItem(sunAngle_hour);
    }
}
