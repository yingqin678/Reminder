package com.item.service;

import com.item.mapper.ItemMapper;
import com.item.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by yingmeng on 2017/7/9 0009.
 */
public class ItemOperateService {

    @Autowired
    private ItemMapper itemMapper;

    public boolean AddItem(ItemModel item){
        if (item.getId() == 0)
        {
            itemMapper.addItem(item);
        }
        else
        {
            itemMapper.updateItem(item);
        }
        return true;
    }

    public List<ItemModel> queryDoingItem(String ip)
    {
        List<ItemModel> items = itemMapper.queryDoingItem(ip);

        return items;
    }

    public List<ItemModel> queryDomeOrDoingItem(String ip)
    {
        List<ItemModel> items = itemMapper.queryDoneOrCancelItems(ip);

        return items;
    }
}
