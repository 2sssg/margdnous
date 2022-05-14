package com.example.margdnous.model.senario;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Senario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    @JoinColumn(name = "x_id")
    private X x;

    @OneToOne
    @JoinColumn(name = "y_id")
    private Y y;

    @OneToOne
    @JoinColumn(name = "z_id")
    private Z z;

    @OneToOne
    @JoinColumn(name = "hue_id")
    private Hue hue;

    @OneToOne
    @JoinColumn(name = "sunAngle_id")
    private SunAngle sunAngle;

}
