package com.example.margdnous.model.unityjson.json3;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class Constants {
    private int framesPerIteration = 1;
    private int totalIterations = 100;
    private int instanceCount = 1;
    private int instanceIndex = 0;
    private int randomSeed = 539662031;
}
