package com.chaquo.python.utils;

import android.app.Application;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.widget.Toolbar;

import android.view.View;

import com.chaquo.python.console.R;

import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;



public class FriendslistActivity extends BacNetActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendslist);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.listView);

        //Create the Person objects
        Person john = new Person("John");
        Person steve = new Person("Steve");
        Person stacy = new Person("Stacy");
        Person ashley = new Person("Ashley");
        Person matt = new Person("Matt");
        Person matt2 = new Person("Matt2");
        Person matt3 = new Person("Matt3");
        Person matt4 = new Person("Matt4");
        Person matt5 = new Person("Matt5");
        Person matt6 = new Person("Matt6");
        Person matt7 = new Person("Matt7");
        Person matt8 = new Person("Matt8");
        Person matt9 = new Person("Matt9");
        Person matt10 = new Person("Matt10");
        Person matt11 = new Person("Matt11");

        //Add the Person objects to an ArrayList
        ArrayList<Person> peopleList = new ArrayList<>();
        peopleList.add(john);
        peopleList.add(steve);
        peopleList.add(stacy);
        peopleList.add(ashley);
        peopleList.add(matt);
        peopleList.add(matt2);
        peopleList.add(matt3);
        peopleList.add(matt4);
        peopleList.add(matt5);
        peopleList.add(matt6);
        peopleList.add(matt7);
        peopleList.add(matt8);
        peopleList.add(matt9);
        peopleList.add(matt10);
        peopleList.add(matt11);

        PersonListAdapter adapter = new PersonListAdapter(this, R.layout.content_friendslist, peopleList);
        mListView.setAdapter(adapter);
    }

    public static class Task extends DebugActivity.Task {
        public Task(Application app) {
            super(app);
        }

        @Override
        public void run() {
            py.getModule("main").callAttr("main");
        } //TODO
    }

    @Override
    protected Class<? extends FriendslistActivity.Task> getTaskClass() {
        return FriendslistActivity.Task.class;
    }
}