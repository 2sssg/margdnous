package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class IItem {
    private IValue value ;

    public IItem(int sunAngle_hour) {
        this.value = new IValue(sunAngle_hour);
    }
}
