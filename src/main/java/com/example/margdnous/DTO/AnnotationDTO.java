package com.example.margdnous.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AnnotationDTO {
    private long id;
    private int categoryID;
    private String category;
    private int labelID;
    private String labelNAME;
}
