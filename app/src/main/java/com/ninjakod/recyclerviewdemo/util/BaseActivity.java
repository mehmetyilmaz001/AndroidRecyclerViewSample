package com.ninjakod.recyclerviewdemo.util;

import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    public void addFragmentToActivity (android.support.v4.app.FragmentManager fragmentManager,
                                       android.support.v4.app.Fragment fragment,
                                       int frameId,
                                       String tag) {

        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(frameId, fragment, tag);
        transaction.commit();
    }
}
