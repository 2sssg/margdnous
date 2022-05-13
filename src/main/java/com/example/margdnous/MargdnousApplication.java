package com.example.margdnous;

import com.example.margdnous.con.DBinit;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class MargdnousApplication {
    public static void main(String[] args) throws IOException, ParseException {
        DBinit dBinit = new DBinit();
        dBinit.makeSqlFile();
        SpringApplication.run(MargdnousApplication.class, args);
    }

}
