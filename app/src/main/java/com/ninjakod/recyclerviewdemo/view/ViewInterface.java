package com.ninjakod.recyclerviewdemo.view;

import com.ninjakod.recyclerviewdemo.data.ListItem;

import java.util.List;

public interface ViewInterface {
    void startDetailActivity(String dateAndTime, String message, int colorResource);

    void setupAdapterAndView(List<ListItem> listOfData);
}
