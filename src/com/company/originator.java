package com.company;

public class originator {

    private String state;

    public void set(String state) {
        System.out.println("Reached " + state);
        this.state = state;
    }//set

    public String getState() {
        return state;
    }

    public mementoObject saveMemento() {
        System.out.println("Saving players current checkpoint");
        return new mementoObject(state);
    }//saveMemento

    public void restoreMemento(mementoObject x) {
        state = x.getState();
        System.out.println(state + " restored from memento: ");
    }//restoreMemento

}//originator