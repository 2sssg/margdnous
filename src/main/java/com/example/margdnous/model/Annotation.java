package com.example.margdnous.model;

import com.example.margdnous.DTO.AnnotationDTO;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@ToString
public class Annotation implements ModelInterface{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="category_id")
    private int categoryID;

    @Column
    private String category;

    @Column(name="label_id")
    private int labelID;

    @Column(name="label_name")
    private String labelNAME;

    @Override
    public AnnotationDTO convertDTO(){
        return new AnnotationDTO(this.id,this.categoryID,this.category,this.labelID,labelNAME);
    }

}
