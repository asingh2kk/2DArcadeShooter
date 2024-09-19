package com.company;

import java.util.ArrayList;

public class caretaker {
    private ArrayList<mementoObject> savedCheckpoints = new ArrayList<mementoObject>();

    public void add(mementoObject state) {
        savedCheckpoints.add(state);
    }//add

    public mementoObject get(int index) {
        return savedCheckpoints.get(index);
    }

}//caretaker