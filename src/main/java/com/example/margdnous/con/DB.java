package com.example.margdnous.con;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@Slf4j
public class DB {
    private Statement stmt;
    private DB(){
        try{
            Connection con = DriverManager.getConnection(INFORMATION.DBURL,INFORMATION.DBID,INFORMATION.DBPW);
            this.stmt = con.createStatement();
        }catch(Exception e){
            log.error("     DB CONNECTION ERROR");
            e.printStackTrace();
        }
    }
    private static class InnerClass{
        private static final DB db = new DB();
    }
    public static DB getInstance(){return InnerClass.db;}

    // select query 날릴때
    public ResultSet selectQuery(String query){
        ResultSet resultSet=null;
        try{
            log.info(query);
            resultSet = stmt.executeQuery(query);
        }catch (Exception e){
            log.error("        query Error");
            e.printStackTrace();
        }
        return resultSet;
    }

    // create, update 같은거 날릴 때
    public void updateQuery(String query){
        try{
            stmt.executeUpdate(query);
        }catch (Exception e){
            log.error("        query Error");
            e.printStackTrace();
        }
    }
}
