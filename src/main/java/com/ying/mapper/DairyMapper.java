package com.ying.mapper;

import com.ying.dairy.model.DariyModel;
import org.mybatis.spring.annotation.MapperScan;

import java.sql.Date;
import java.util.List;

/**
 * Created by yingmeng on 2017/6/5 0005.
 */
@MapperScan
public interface DairyMapper {

    List<DariyModel> queryDairyOverView();

    List<DariyModel> queryDairy(Date begin, Date end);

    void saveDairy(DariyModel model);
}
