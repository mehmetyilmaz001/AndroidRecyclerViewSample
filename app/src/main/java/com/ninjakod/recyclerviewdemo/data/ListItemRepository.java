package com.ninjakod.recyclerviewdemo.data;

import android.arch.lifecycle.LiveData;

import java.util.List;

import javax.inject.Inject;

public class ListItemRepository {

    private final ListItemDao listItemDao;

    @Inject
    public ListItemRepository(ListItemDao listItemDao){
        this.listItemDao = listItemDao;
    }

    public LiveData<List<ListItem>> getListItems(){
        return listItemDao.getListItems();
    }

    public LiveData<ListItem> getListItem(String itemId){
        return listItemDao.getListItemById(itemId);
    }

    public void deleteListItem(ListItem listItem){
        listItemDao.deleteListItem(listItem);
    }

    public void insertListItem(ListItem listItem){
        listItemDao.insertListItem(listItem);
    }

}
