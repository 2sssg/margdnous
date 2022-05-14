package com.example.margdnous.model.unityjson.json3;

import lombok.Data;

@Data
public class Item {
    private Depth depth = new Depth();
    private LayerCount layerCount = new LayerCount();
    private SeparationDistance separationDistance = new SeparationDistance();
}
