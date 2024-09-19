package com.company;

public class GetEnemyBuilder {

    public static EnemyBuilder getEnemyBuilder(String enemyType) throws Exception{
        if(enemyType=="Normal"){
            return new NormalEnemyBuilder();
        }
        if(enemyType=="Hard"){
            return  new HardEnemyBuilder();
        }
        throw new Exception("Enemy Type Does Not Exist");
    }
}
