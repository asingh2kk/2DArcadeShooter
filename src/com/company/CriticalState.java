
package com.company;

public class CriticalState implements State {
    private String stateName;

    public CriticalState() {
        this.stateName = "CriticalState";
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
        System.out.println("Firing a Powerful Shot!");
    }

    @Override
    public void isShot() {
        System.out.println("Barely holding on!");
    }

    @Override
    public void gameOver() {
        System.out.println("The game isn't over because the player is still alive. Barely.");
    }
}
