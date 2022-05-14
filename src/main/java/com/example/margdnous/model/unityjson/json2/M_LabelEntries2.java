package com.example.margdnous.model.unityjson.json2;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;

@ToString
@Data
public class M_LabelEntries2 {
    private String label;
    private Color color = new Color();

    public M_LabelEntries2(String label) {
        this.label = label;
    }
}
