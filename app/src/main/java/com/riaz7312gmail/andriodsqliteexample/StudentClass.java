package com.riaz7312gmail.andriodsqliteexample;

/**
 * Created by HP on 6/25/2016.
 */
public class StudentClass {
    private int id;
    private String name;



    public long getId() {
        return id;
    }
    public void setId(int id){
        this.id =id;
    }
    public String getName(){
        return this.name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }


}
