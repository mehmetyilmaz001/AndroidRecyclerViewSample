package com.ninjakod.recyclerviewdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ninjakod.recyclerviewdemo.R;
import com.ninjakod.recyclerviewdemo.data.FakeDataSource;
import com.ninjakod.recyclerviewdemo.data.ListItem;
import com.ninjakod.recyclerviewdemo.logic.Controller;

import java.util.List;

public class ListActivity extends AppCompatActivity implements ViewInterface{

    private static final String EXTRA_DATE_AND_TIME = "EXTRA_DATE_AND_TIME";
    private static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";
    private static final String EXTRA_COLOR = "EXTRA_COLOR";

    private List<ListItem> listOfData;

    private LayoutInflater layoutInflater;
    private RecyclerView recyclerView;
    private CustomAdapter adapter;

    private Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        recyclerView = (RecyclerView)findViewById(R.id.rec_list_activity);
        layoutInflater = getLayoutInflater();

        controller = new Controller(this, new FakeDataSource());

    }

    @Override
    public void startDetailActivity(String dateAndTime, String message, int colorResource) {
        Intent intent = new Intent(this, DetailActivity.class);

        intent.putExtra(EXTRA_DATE_AND_TIME, dateAndTime);
        intent.putExtra(EXTRA_MESSAGE, message);
        intent.putExtra(EXTRA_COLOR, colorResource);

        startActivity(intent);
    }

    @Override
    public void setupAdapterAndView(List<ListItem> listOfData) {
        this.listOfData = listOfData;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        recyclerView.setAdapter(adapter);
    }

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder>{
        @Override
        public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = layoutInflater.inflate(R.layout.item_data, parent, false);
            return new CustomViewHolder(v);
        }

        @Override
        public void onBindViewHolder(CustomViewHolder holder, int position) {
            ListItem currentItem = listOfData.get(position);
            holder.coloredCircle.setBackgroundResource(
                    currentItem.getColorResource()
            );

            holder.message.setText(
                    currentItem.getMessage()
            );

            holder.dateAndTime.setText(
                    currentItem.getDateAndTime()
            );
        }

        @Override
        public int getItemCount() {
            return listOfData.size();
        }

        class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

            private View coloredCircle;
            private TextView dateAndTime;
            private TextView message;
            private ViewGroup container;


            public CustomViewHolder(View itemView) {
                super(itemView);

                this.coloredCircle = itemView.findViewById(R.id.imv_item_circle);
                this.dateAndTime   = itemView.findViewById(R.id.txt_date_and_time);
                this.message       = itemView.findViewById(R.id.txt_message);
                this.container     = itemView.findViewById(R.id.root_list_item);

                this.container.setOnClickListener(this);

            }

            @Override
            public void onClick(View view) {
                ListItem listItem = listOfData.get(
                        this.getAdapterPosition()
                );

                controller.onListItemClick(listItem);
            }
        }
    }
}
