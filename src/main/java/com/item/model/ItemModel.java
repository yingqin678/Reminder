package com.item.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by yingmeng on 2017/7/9 0009.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemModel {
    int id;

    String content;

    long deadTime;

    int result;

    int levelValue;

    int type;

    String ip;
}
