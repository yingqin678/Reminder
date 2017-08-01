package com.item.model;

/**
 * Created by yingmeng on 2017/7/9 0009.
 */
public enum Level {
    LOW(0),
    NARMAL(1),
    EMERGENCY(2);

    int value;

    Level(int v) {
        value = v;
    }

    public int getValue() {
        return value;
    }
}
