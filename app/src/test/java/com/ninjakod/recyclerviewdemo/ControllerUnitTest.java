package com.ninjakod.recyclerviewdemo;

import com.ninjakod.recyclerviewdemo.data.DataSourceInterface;
import com.ninjakod.recyclerviewdemo.data.ListItem;
import com.ninjakod.recyclerviewdemo.logic.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class ControllerUnitTest {

    @Mock
    DataSourceInterface dataSource;

    @Mock
    ViewInterface view;

    Controller controller;

    private static final ListItem testItem = new ListItem(
      "6:00AM 05/05/2018",
      "Test body message",
      R.color.RED
    );


    @Before
    public void setupTest(){
        MockitoAnnotations.initMocks(this);
        controller = new Controller(view, dataSource);
    }

    @Test
    public void onGetListDataSuccessful() {
        //Setup any data we need for the test
        ArrayList<ListItem> listOfData = new ArrayList<>();
        listOfData.add(testItem);

        //Setup our mocks to return data
        Mockito.when(dataSource.getListOfData()).thenReturn(listOfData);

        //Call the method(Unit) we are testing
        controller.getListFromDataSource();

        //Check how the tested class response to the data it receives
        //or test its behaviour
        Mockito.verify(view).setupAdapterAndView(listOfData);

    }

    @Test
    public void onListItemClicked(){
        controller.onListItemClick(testItem);

        Mockito.verify(view).startDetailActivity(
                testItem.getDateAndTime(),
                testItem.getMessage(),
                testItem.getColorResource()
        );
    }
}