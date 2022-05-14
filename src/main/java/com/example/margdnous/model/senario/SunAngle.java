package com.example.margdnous.model.senario;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class SunAngle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private int hour;

    @Column(name = "day_of_year")
    private int dayOfYear;

    @Column
    private int latitude;

}
