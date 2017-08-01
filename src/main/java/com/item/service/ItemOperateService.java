package com.item.service;

import com.item.mapper.ItemMapper;
import com.item.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yingmeng on 2017/7/9 0009.
 */
public class ItemOperateService {
    @Autowired
    private ItemMapper mapper;

    public boolean AddItem(ItemModel item){
        if (item.getId() == 0)
        {
            mapper.addItem(item);
        }
        else
        {
            mapper.updateItem(item);
        }
        return true;
    }

    public List<ItemModel> queryDoingItem()
    {
        List<ItemModel> items = mapper.queryDoingItem();

        return items;
    }

    public List<ItemModel> queryDomeOrDoingItem()
    {
        List<ItemModel> items = mapper.queryDoneOrCancelItems();

        return items;
    }
}
