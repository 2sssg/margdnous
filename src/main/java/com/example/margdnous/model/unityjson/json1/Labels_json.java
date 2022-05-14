package com.example.margdnous.model.unityjson.json1;

import com.example.margdnous.con.DB;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@ToString
@Data
public class Labels_json {
    private List<M_LabelEntries> m_labelEntriesList = new ArrayList<>();
    private boolean autoAssignIds = true;
    private int startingLabelId=1;

    public Labels_json(String labelnames) throws SQLException {
        for(String s : labelnames.split(",")){
            ResultSet resultSet = DB.getInstance().selectQuery("SELECT label_name,label_id FROM Annotation WHERE label_name like '"+ s+"'");
            resultSet.next();
            log.info(resultSet.getString(1));
            log.info(resultSet.getString(2));
            m_labelEntriesList.add(new M_LabelEntries(resultSet.getString(1),Integer.parseInt(resultSet.getString(2))));
        }
    }
}
