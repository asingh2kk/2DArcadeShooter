
package com.company;

public interface State {
    // Method to get the state's name
    String getStateName();
    
    void shoot();
    void isShot();
    void gameOver();
}
