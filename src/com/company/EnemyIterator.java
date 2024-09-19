package com.company;

import java.util.Iterator;
import java.util.List;

public class EnemyIterator implements Iterator<Enemy> {
    private List<Enemy> enemies;
    private int position;

    public EnemyIterator(List<Enemy> enemies)
    {
        this.enemies = enemies;
        position = 0;
    }

    @Override
    public Enemy next() {
        return enemies.get(position++);
    }

    @Override
    public boolean hasNext() {
        if(position >= enemies.size())
            return false;
        return true;
    }
}
