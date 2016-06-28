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

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,values);

        setListAdapter(adapter);

    }
    public void deleteFirstUser(View view) {

        ArrayAdapter adapter = (ArrayAdapter) getListAdapter();
        StudentClass stud = null;

        if (getListAdapter().getCount() > 0) {
            stud = (StudentClass) getListAdapter().getItem(0);
            studentDBoperations.deleteStudent(stud);
            adapter.remove(stud);
        }

    }

    @Override
    protected void onResume() {
        studentDBoperations.open();
        super.onResume();
    }

    @Override
    protected void onPause() {
        studentDBoperations.close();
        super.onPause();
    }

}
