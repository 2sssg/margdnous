package com.example.margdnous.repository;

import com.example.margdnous.model.InputData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InputDataRepository extends JpaRepository<InputData,Long> {
    InputData findByMyDataKey(int myDataKey);
}
