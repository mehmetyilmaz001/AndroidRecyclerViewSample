/*
 * *
 *  * Copyright (C) 2017 Ryan Kay Open Source Project
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.ninjakod.recyclerviewdemo.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.ninjakod.recyclerviewdemo.data.ListItem;
import com.ninjakod.recyclerviewdemo.data.ListItemRepository;


/**
 * Created by R_KAY on 8/3/2017.
 */

public class ListItemViewModel extends ViewModel {

    private ListItemRepository repository;

    ListItemViewModel(ListItemRepository repository) {
        this.repository = repository;
    }

    public LiveData<ListItem> getListItemById(String itemId){
       return repository.getListItem(itemId);
    }

}

