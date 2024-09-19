
package com.company;

public class FullState implements State {
    private String stateName;

    public FullState() {
        this.stateName = "FullState";
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
        System.out.println("Firing a Normal Shot.");
    }

    @Override
    public void isShot() {
        System.out.println("SHIELDS DOWN! DIVERTING ALL POWER TO OFFENSE!");
    }

    @Override
    public void gameOver() {
        System.out.println("The game isn't over because the player is still alive.");
    }
}
