package com.item.model;

/**
 * Created by yingmeng on 2017/7/9 0009.
 */
public enum Result {
    DOING(0),
    DONE(1),
    CANCEL(2);

    private int result;

    Result(int value)
    {
        this.result = value;
    }

    public int getResult() {
        return result;
    }
}
