
package com.company;

public class GonerState implements State {
    private String stateName;

    public GonerState() {
        this.stateName = "GonerState";
    }

    @Override
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public void shoot() {
        System.out.println("The Player can't shoot because they are dead.");
    }

    @Override
    public void isShot() {
        System.out.println("The Player can't be shot because they are already dead.");
    }

    @Override
    public void gameOver() {
        System.out.println("Running the Game Over sequence.");
    }
}
