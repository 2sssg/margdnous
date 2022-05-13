package com.example.margdnous.con;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class DBinit {

    private String initSQL;

    public DBinit(){
        initSQL = "";
    }
    private void makeSQL() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Reader reader = new FileReader("src/main/java/com/example/margdnous/con/annotation_definitions.json");

        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        JSONArray jsonArray = (JSONArray) jsonObject.get("annotation_definitions");
        jsonObject = (JSONObject) jsonArray.get(0);
        jsonArray = (JSONArray) jsonObject.get("spec");
        for(int i=0; i<jsonArray.size(); ++i){
            jsonObject = (JSONObject) jsonArray.get(i);
            String label_name = (String) jsonObject.get("label_name");
            long label_id = (long) jsonObject.get("label_id");

            int category_id=-1;
            for(Category c : Category.values()){
                int ca_id = c.find(label_name.split("_")[0]);
                if(ca_id!= -1){
                    category_id = ca_id;
                    break;
                }
            }
            String category = label_name.split("_")[0];
            this.initSQL += "INSERT INTO Annotation(category_id,category,label_id,label_name) VALUES(";
            this.initSQL += category_id+",\""+category+"\","+label_id+",\""+label_name+"\");\n";
        }
    }
    public void makeSqlFile() throws IOException, ParseException {
        makeSQL();
        String filePath = "/Users/2sssg/workspace/margdnous/src/main/resources/import.sql";
        File file = new File(filePath);
        file.delete();
        file = new File(filePath);
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));
        bw.write(this.initSQL);
        bw.flush();
        bw.close();
    }


}
