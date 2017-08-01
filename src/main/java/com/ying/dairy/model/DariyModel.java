package com.ying.dairy.model;

import lombok.Data;

import java.sql.Date;

/**
 * Created by yingmeng on 2017/5/21 0021.
 */
@Data
public class DariyModel {

    //标题
    String title;

    //内容
    String content;

    //日记时间
    Date dairyTime;

    //日记当天生活水平
    int level;

    int id;
}
