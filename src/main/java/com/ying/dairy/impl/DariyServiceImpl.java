package com.ying.dairy.impl;

import com.ying.dairy.DariyService;
import com.ying.dairy.model.DariyModel;
import com.ying.mapper.DairyMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yingmeng on 2017/5/21 0021.
 */
public class DariyServiceImpl implements DariyService {

//    @Autowired
    private DairyMapper mapper;

    @Override
    public boolean saveDariy(String title, String content, int level)
    {
        DariyModel model = new DariyModel();
        model.setTitle(title);
        model.setContent(content);
        model.setLevel(level);
        model.setDairyTime(new java.sql.Date((new Date()).getTime()));
        try {
            mapper.saveDairy(model);
        } catch (Exception e) {
            System.out.printf("Failed to insert into dairy", e);
            return false;
        }

        return true;
    }

    @Override
    public List<DariyModel> queryContent(String beginDate, String endDate) {
//        List<DariyModel> models = mapper.queryDairy();
        return new ArrayList<>();
    }

    @Override
    public List<DariyModel> queryAll() {
        return mapper.queryDairyOverView();
    }
}
