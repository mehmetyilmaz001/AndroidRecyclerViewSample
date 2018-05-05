package com.ninjakod.recyclerviewdemo.logic;

import com.ninjakod.recyclerviewdemo.data.DataSourceInterface;
import com.ninjakod.recyclerviewdemo.data.ListItem;
import com.ninjakod.recyclerviewdemo.view.ViewInterface;

public class Controller {
    private ViewInterface view;
    private DataSourceInterface dataSource;

    public Controller(ViewInterface view, DataSourceInterface dataSource) {
        this.view = view;
        this.dataSource = dataSource;
        getListFromDataSource();
    }


    public void getListFromDataSource(){
        view.setupAdapterAndView(dataSource.getListOfData());
    }

    public void onListItemClick(ListItem listItem){
        view.startDetailActivity(
                listItem.getDateAndTime(),
                listItem.getMessage(),
                listItem.getColorResource()
        );
    }
}
