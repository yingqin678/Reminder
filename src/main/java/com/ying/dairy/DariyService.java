package com.ying.dairy;

import com.ying.dairy.model.DariyModel;

import java.util.List;

/**
 * Created by yingmeng on 2017/5/21 0021.
 */
public interface DariyService {

    /**
     * 保存日志内容
     * @param title
     * @param content
     * @param level
     * @return
     */
    boolean saveDariy(String title, String content, int level);

    /**
     * 查询一定时间范围内的日记内容
     * @param beginDate
     * @param endDate
     * @return
     */
    List<DariyModel> queryContent(String beginDate, String endDate);

    List<DariyModel> queryAll();
}
