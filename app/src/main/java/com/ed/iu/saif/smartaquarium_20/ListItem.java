package com.ed.iu.saif.smartaquarium_20;

public class ListItem {

    private String time;
    private int  days;
    private int id;

    public ListItem(int id,String time,int days) {
        this.time = time;
        this.id  =  id;
        this.days=days;


    }


    public String getName() {
        return time;
    }

    public int getID() {
        return id;
    }

    public int getDays() {
        return days;
    }
}
