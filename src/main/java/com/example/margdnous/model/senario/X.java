package com.example.margdnous.model.senario;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class X {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private int min;

    @Column
    private int max;
}
