package com.ninjakod.recyclerviewdemo.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {ListItem.class}, version = 1)
public abstract class ListItemDatabase extends RoomDatabase{
    public abstract ListItemDao listItemDao();
}
