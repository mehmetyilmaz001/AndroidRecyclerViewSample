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

package com.ninjakod.recyclerviewdemo.create;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.ninjakod.recyclerviewdemo.R;
import com.ninjakod.recyclerviewdemo.util.BaseActivity;


public class CreateActivity extends BaseActivity {

    private static final String CREATE_FRAG = "CREATE_FRAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);


        FragmentManager manager = getSupportFragmentManager();

        CreateFragment fragment = (CreateFragment) manager.findFragmentByTag(CREATE_FRAG);

        if (fragment == null) {
            fragment = CreateFragment.newInstance();
        }

        addFragmentToActivity(manager,
                fragment,
                R.id.root_activity_create,
                CREATE_FRAG
        );

    }
}
