package com.ninjakod.recyclerviewdemo.data;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface ListItemDao {

    @Query("select * from ListItem")
    LiveData<List<ListItem>> getListItems();

    @Query("select * from ListItem where itemId = :itemId")
    LiveData<ListItem> getListItemById(String itemId);

    @Insert(onConflict = REPLACE)
    long insertListItem(ListItem listItem);

    @Delete
    void deleteListItem(ListItem listItem);

}
