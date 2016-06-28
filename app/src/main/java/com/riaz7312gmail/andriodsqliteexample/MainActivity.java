package com.riaz7312gmail.andriodsqliteexample;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class MainActivity extends ListActivity {

    private StudentOperations studentDBoperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        studentDBoperations = new StudentOperations(this);
        studentDBoperations.open();

        List values = studentDBoperations.getAllStudents();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.simple_list_1,values);

        setListAdapter(adapter);

    }
    public  void addUser(View view){
        ArrayAdapter adapter =

                (() .0)






        ............................................


    }

}
