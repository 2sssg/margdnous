package com.example.margdnous.model;


import com.example.margdnous.model.senario.Senario;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class InputData {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String url;

    @Column(name="is_end")
    private boolean isEnd;

    @Column(name="my_data_key")
    private int myDataKey;

    @Column
    private String labelNameList;

    @OneToOne
    @JoinColumn(name = "senario_id")
    private Senario senario;



}
