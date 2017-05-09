package com.myt.ikili.besindeerleri;

/**
 * Created by ikili on 26.01.2017.
 */

public class Person {
    private String Name;
    private int PicResID;

    public Person(String name){
        Name = name;
    }
    public Person(String name,int imageID){
        Name = name;
        PicResID = imageID;
    }


    public String getName() {
        return Name;
    }


    public int getPictureResourceID() {
        return PicResID;
    }
}