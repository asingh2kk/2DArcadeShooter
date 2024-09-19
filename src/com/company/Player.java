
package com.company;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Player {
    public static Player p = new Player();

    private State fullState;
    private State criticalState;
    private State gonerState;

    private State currentState;

    private Player() {
        this.fullState = new FullState();
        this.criticalState = new CriticalState();
        this.gonerState = new GonerState();
        this.currentState = fullState;  // Initial state
    }

    public static Player getPlayer() {
        return p;
    }

    // Setters and Getters for states
    public void setState(State state) {
        this.currentState = state;
    }

    public State getState() {
        return this.currentState;
    }

    // Method to return the current state's name
    public String getStateName() {
        return this.currentState.getStateName();
    }

    // Other attributes and methods related to position, shooting, and movement
    private int x = 250;
    private int y = 400;
    private int width = 21;
    private int height = 21;
    private int shootPartWidth = 3;
    private int shootPartHeight = 5;
    private int speed = 6;

    private int bulletWidth = 3;
    private int bulletHeight = 5;
    private int bulletSpeed = 10;
    private int bulletX = 0;
    private int bulletY = 0;
    private boolean isShot = false;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    void drawPlayer(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, width, height);
        g.fillRect(x + (width / 2) - (shootPartWidth / 2), y - shootPartHeight, shootPartWidth, shootPartHeight);

        if (isShot) {
            g.setColor(Color.red);
            g.fillRect(bulletX, bulletY, bulletWidth, bulletHeight);
            if (bulletY + bulletHeight <= y) {
                g.setColor(Color.white);
                g.fillRect(bulletX, bulletY + bulletSpeed, bulletWidth, bulletHeight);
            }

            EnemyIterator enemyit = Enemy.iterator();
            Boolean wonGame = true;
            while (enemyit.hasNext()) {
                Enemy enemy = enemyit.next();
                if (bulletY < enemy.getY() + enemy.getHeight() && bulletY > enemy.getY() && bulletX > enemy.getX() && bulletX < enemy.getX() + enemy.getWidth()) {
                    enemy.kill();
                }
                if (enemy.isAlive()) wonGame = false;
            }
            if (wonGame) {
                Main.winGame();
            }

            bulletY -= bulletSpeed;
            if (bulletY < 0) {
                isShot = false;
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        switch (k) {
            case KeyEvent.VK_D:
                x += speed;
                break;
            case KeyEvent.VK_A:
                x -= speed;
                break;
        }
        if (k == KeyEvent.VK_SPACE) {
            shoot();
        }
    }

    void shoot() {
        if (!isShot) {
            System.out.println("Shooting");
            isShot = true;
            bulletX = x + (width / 2) - (bulletWidth / 2);
            bulletY = y - bulletHeight;
        }
    }

    public static void resetPlayer() {
        p = new Player();
    }
}
