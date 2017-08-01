package com.item.mapper;

import com.item.model.ItemModel;

import java.util.List;

/**
 * Created by yingmeng on 2017/7/9 0009.
 */
public interface ItemMapper {
    void addItem(ItemModel item);

    void updateItem(ItemModel item);

    List<ItemModel> queryDoingItem();

    List<ItemModel> queryDoneOrCancelItems();
}
