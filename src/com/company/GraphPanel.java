package com.company;

        import java.awt.Color;
        import java.awt.Dimension;
        import java.awt.Graphics;
        import java.awt.event.KeyEvent;
        import javax.swing.*;

public class GraphPanel extends JPanel{

    static long updateFrame=0;
    static long enemyShoot=0;
    static long enemyMove=0;
    boolean inGame=true;
    private boolean paused=false;

    public GraphPanel() {
        setPreferredSize(new Dimension(200,200));
        try {
            start();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public void start() throws Exception {
        for(int i=0;i<5;i++){
            EnemyCreator ec=new EnemyCreator(GetEnemyBuilder.getEnemyBuilder("Normal"));
            ec.makeEnemy(100+i*50, 100);
            Enemy.enemies.add(ec.getEnemy());
        }

        EnemyCreator ec=new EnemyCreator(GetEnemyBuilder.getEnemyBuilder("Hard"));
        ec.makeEnemy(100, 50);
        Enemy.enemies.add(ec.getEnemy());


        Thread thread = new Thread(){
            public void run(){
                while(inGame) {
                    if (!paused) {
                        updateFrame++;
                        enemyMove++;
                        enemyShoot++;
                        if (updateFrame >= 10) {
                            repaint();
                            updateFrame = 0;
                        }
                        EnemyIterator enemyit1 = Enemy.iterator();
                        while (enemyit1.hasNext()) {
                            Enemy enemy = enemyit1.next();
                            enemy.movementTimer++;
                            if (enemy.movementTimer >= enemy.getSpeed()) {
                                enemy.moveRight();
                                enemy.movementTimer = 0;
                            }
                        }
                        if (enemyShoot >= 3000) {
                            EnemyIterator enemyit2 = Enemy.iterator();
                            while (enemyit2.hasNext()) {
                                Enemy enemy = enemyit2.next();
                                enemy.shoot();
                            }
                            enemyShoot = 0;
                        }
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.print("");
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        };

        thread.start();
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0,0,500,500);
        Player.p.drawPlayer(g);
        EnemyIterator enemyit=Enemy.iterator();
        while(enemyit.hasNext()){
            Enemy enemy=enemyit.next();
            enemy.drawEnemy(g);
        }
    }

    public void keyPressed(KeyEvent e) {
//        int k = e.getKeyCode();
//
//        switch (k) {
//            case KeyEvent.VK_D:
//                x+=speed;
//                break;
//            case KeyEvent.VK_A:
//                x-=speed;
//                break;
//        }
//        if(k==KeyEvent.VK_SPACE){
//            shoot();
//        }
        if(!paused) {
            Player.p.keyPressed(e);
            if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                paused=true;
                System.out.println("Paused Game");
            }
        }
        else{
            if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
                paused=false;
                System.out.println("Unpaused Game");
            }
        }
    }

    public void endGame(){
        inGame=false;
    }
}

