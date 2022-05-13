package com.example.margdnous.DTO;

import com.example.margdnous.model.ModelInterface;
import lombok.*;

import javax.persistence.Column;

@Getter
@Setter
public class AnnotationDTO extends DTO{
    private int categoryID;
    private String category;
    private int labelID;
    private String labelNAME;

    public AnnotationDTO(long id, int categoryID, String category, int labelID, String labelNAME) {
        super(id);
        this.categoryID = categoryID;
        this.category = category;
        this.labelID = labelID;
        this.labelNAME = labelNAME;
    }
}
