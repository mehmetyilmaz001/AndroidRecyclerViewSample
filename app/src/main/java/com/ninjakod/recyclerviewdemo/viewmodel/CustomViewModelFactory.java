package com.ninjakod.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.ninjakod.recyclerviewdemo.data.ListItemRepository;

public class CustomViewModelFactory implements ViewModelProvider.Factory{
    private final ListItemRepository listItemRepository;

    public CustomViewModelFactory(ListItemRepository listItemRepository) {
        this.listItemRepository = listItemRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if(modelClass.isAssignableFrom(ListItemCollectionViewModel.class)){
            return  (T) new ListItemCollectionViewModel(listItemRepository);

        }else if(modelClass.isAssignableFrom(ListItemViewModel.class)){
            return  (T) new ListItemViewModel(listItemRepository);

        }else if(modelClass.isAssignableFrom(NewListItemViewModel.class)){
            return  (T) new NewListItemViewModel(listItemRepository);

        }else{
            throw new IllegalArgumentException("VieModel not found");
        }

    }
}
