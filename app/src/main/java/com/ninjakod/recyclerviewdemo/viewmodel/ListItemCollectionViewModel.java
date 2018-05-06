package com.ninjakod.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;

import com.ninjakod.recyclerviewdemo.data.ListItem;
import com.ninjakod.recyclerviewdemo.data.ListItemRepository;

import java.util.List;

import javax.inject.Inject;

public class ListItemCollectionViewModel extends ViewModel {

    private ListItemRepository listItemRepository;

    @Inject
    public ListItemCollectionViewModel(ListItemRepository listItemRepository) {
        this.listItemRepository = listItemRepository;
    }

    public LiveData<List<ListItem>> getListItems(){
        return listItemRepository.getListItems();
    }

    public void deleteListItem(ListItem listItem){
        DeleteItemTask deleteItemTask = new DeleteItemTask();
        deleteItemTask.execute(listItem);
    }

    private class  DeleteItemTask extends AsyncTask<ListItem, Void, Void>{

        @Override
        protected Void doInBackground(ListItem... listItems) {
            listItemRepository.deleteListItem(listItems[0]);
            return null;
        }
    }
}
