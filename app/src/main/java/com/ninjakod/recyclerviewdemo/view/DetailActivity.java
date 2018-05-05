package com.ninjakod.recyclerviewdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ninjakod.recyclerviewdemo.R;
import com.ninjakod.recyclerviewdemo.data.ListItem;
import com.ninjakod.recyclerviewdemo.logic.Controller;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";

    private List<ListItem> listOfData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;

    private Controller controller;

    private View coloredBackground;
    private TextView dateAndTime;
    private TextView message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();
        String dateAndTimeExtra = intent.getStringExtra(EXTRA_DATE_AND_TIME);
        String messageExtra = intent.getStringExtra(EXTRA_MESSAGE);
        int colorExtra = intent.getIntExtra(EXTRA_COLOR, 0);

        dateAndTime = findViewById(R.id.txt_date_and_time_header);
        dateAndTime.setText(dateAndTimeExtra);

        message = findViewById(R.id.txt_message_body);
        message.setText(messageExtra);

        coloredBackground = findViewById(R.id.cont_colored_background);
        coloredBackground.setBackgroundColor(ContextCompat.getColor(this, colorExtra));
    }



}
