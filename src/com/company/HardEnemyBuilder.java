package com.company;

import java.awt.*;

public class HardEnemyBuilder implements EnemyBuilder {
    private Enemy enemy;

    @Override
    public void createEnemy(int x, int y) {
        enemy=Enemy.makeEnemy(Player.p, x, y);
    }

    @Override
    public void setSpeed() {
        enemy.setSpeed(3);
    }

    @Override
    public void setGraphics() {
        enemy.setGraphics(11, 11, 3, 1, Color.red);
    }

    @Override
    public void setBulletGraphics() {
        enemy.setBulletGraphics(3, 1, Color.red);
    }

    @Override
    public void setBulletSpeed() {
        enemy.setBulletSpeed(15);
    }

    @Override
    public Enemy getEnemy() {
        return enemy;
    }
}
