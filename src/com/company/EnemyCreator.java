package com.company;

public class EnemyCreator {
    private EnemyBuilder eb;

    public EnemyCreator(EnemyBuilder eb){
        this.eb=eb;
    }

    public void makeEnemy(int x, int y){
        eb.createEnemy(x, y);
        eb.setSpeed();
        eb.setGraphics();
        eb.setBulletGraphics();
        eb.setBulletSpeed();
    }

    public Enemy getEnemy(){
        return eb.getEnemy();
    }
}
