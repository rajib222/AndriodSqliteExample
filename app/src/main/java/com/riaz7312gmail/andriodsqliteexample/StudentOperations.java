package com.riaz7312gmail.andriodsqliteexample;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class StudentOperations {

    private DataBaseWrapper dbHelper;
    private String[] STUDENT_TABLE_COLUMNS = { DataBaseWrapper.STUDENT_ID, DataBaseWrapper.STUDENT_NAME };
    private SQLiteDatabase database;

    public StudentOperations(Context context) {
        dbHelper = new DataBaseWrapper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public StudentClass addStudent(String name) {

        ContentValues values = new ContentValues();

        values.put(DataBaseWrapper.STUDENT_NAME, name);

        long studId = database.insert(DataBaseWrapper.STUDENTS, null, values);


        Cursor cursor = database.query(DataBaseWrapper.STUDENTS,
                STUDENT_TABLE_COLUMNS, DataBaseWrapper.STUDENT_ID + " = "
                        + studId, null, null, null, null);

        cursor.moveToFirst();

        StudentClass newComment = parseStudent(cursor);
        cursor.close();
        return newComment;
    }

    public void deleteStudent(StudentClass comment) {
        long id = comment.getId();
        System.out.println("Comment deleted with id: " + id);

        database.delete(DataBaseWrapper.STUDENTS, DataBaseWrapper.STUDENT_ID
                + " = " + id, null);
    }

    public List getAllStudents() {
        List students = new ArrayList();

        Cursor cursor = database.query(DataBaseWrapper.STUDENTS,
                STUDENT_TABLE_COLUMNS, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            StudentClass student = parseStudent(cursor);
            students.add(student);
            cursor.moveToNext();
        }

        cursor.close();
        return students;
    }

    private StudentClass parseStudent(Cursor cursor) {
        StudentClass student = new StudentClass();
        student.setId((cursor.getInt(0)));
        student.setName(cursor.getString(1));
        return student;
    }
}
