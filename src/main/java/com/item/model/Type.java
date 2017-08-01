package com.item.model;

public enum Type {
    TIME(1),
    TODO(2);

    private int value;

    Type(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
