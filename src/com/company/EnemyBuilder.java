package com.company;

import java.awt.*;

public interface EnemyBuilder {
    public void createEnemy(int x, int y);
    public void setSpeed();
    public void setGraphics();
    public void setBulletGraphics();
    public void setBulletSpeed();
    public Enemy getEnemy();
}
