package com.example.margdnous.repository;

import com.example.margdnous.model.Annotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnnotationReposiroty extends JpaRepository<Annotation,Long> {
    List<Annotation> findByCategory(String category);
    Annotation findByLabelNAME(String label_name);

}
