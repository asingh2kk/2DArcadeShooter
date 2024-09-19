package com.company;

import java.awt.*;

public class NormalEnemyBuilder implements EnemyBuilder{
    private Enemy enemy;

    @Override
    public void createEnemy(int x, int y) {
        enemy=Enemy.makeEnemy(Player.p, x, y);
    }

    @Override
    public void setSpeed() {
        enemy.setSpeed(6);
    }

    @Override
    public void setGraphics() {
        enemy.setGraphics(21, 21, 5, 3, Color.black);
    }

    @Override
    public void setBulletGraphics() {
        enemy.setBulletGraphics(5, 3, Color.black);
    }

    @Override
    public void setBulletSpeed() {
        enemy.setBulletSpeed(5);
    }

    @Override
    public Enemy getEnemy() {
        return enemy;
    }
}
