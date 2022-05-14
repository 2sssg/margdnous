package com.example.margdnous.model.unityjson.json2;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Data
public class Sementic_json {
    private List<M_LabelEntries2> m_labelEntries = new ArrayList<>();

    public Sementic_json(String labelName) {
        for(String s : labelName.split(",")){
            m_labelEntries.add(new M_LabelEntries2(s));
        }
    }
}
