package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Enemy {
    private Player player;
    public static List<Enemy> enemies=new ArrayList<Enemy>();

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

    public int getSpeed() {
        return speed;
    }

    private int x;
    private int y;
    private int width;
    private int height;
    private int shootPartWidth;
    private int shootPartHeight;
    private int speed;
    private Color enemyColor;

    private int bulletWidth;
    private int bulletHeight;
    private int bulletSpeed;
    private int bulletX=0;
    private int bulletY=0;
    private Color bulletColor;
    //private boolean isShot=false;
    private boolean goingRight=true;

    public int movementTimer=0;

    public static Enemy makeEnemy(Player p, int startX, int startY){
        return new Enemy(p, startX, startY);
    }

    public boolean isAlive() {
        return isAlive;
    }

    private boolean isAlive=true;

    public Enemy(Player p, int startX, int startY) {
        player=p;
        x=startX;
        y=startY;
    }

    void drawEnemy(Graphics g){
        if(isAlive) {
            g.setColor(enemyColor);
            g.fillRect(x, y, width, height);
            g.fillRect(x + (width / 2) - (shootPartWidth / 2), y + height, shootPartWidth, shootPartHeight);

            g.setColor(bulletColor);
            g.fillRect(bulletX, bulletY, bulletWidth, bulletHeight);
            if (bulletY - bulletHeight >= y) {
                g.setColor(Color.white);
                g.fillRect(bulletX, bulletY - bulletSpeed, bulletWidth, bulletHeight);
            }
            if(bulletY<player.getY()+player.getHeight() && bulletY>player.getY() && bulletX>player.getX() && bulletX<player.getX()+player.getWidth()){
                //This is what happens when the player gets shot
                Main.endGame();
            }
            bulletY += bulletSpeed;
        }
    }

    void shoot(){
        //if(!isShot&&isAlive) {
            //System.out.println("Shooting");
            //isShot=true;
            bulletX=x+(width/2)-(bulletWidth/2);
            bulletY=y-bulletHeight;
        //}
    }

    void moveRight() {
        if (isAlive) {
            if (goingRight) {
                x += 1;
                if (x > 450) {
                    goingRight = false;
                }
            } else {
                x -= 1;
                if (x < 50) {
                    goingRight = true;
                }
            }
        }
    }

    public void kill(){
        isAlive=false;
        System.out.println("DIE");
    }

    public static EnemyIterator iterator(){
        return new EnemyIterator(enemies);
    }

    public void setPosition(int x, int y){
        this.x=x;
        this.y=y;
    }

    public void setSpeed(int speed){
        this.speed=speed;
    }

    public void setGraphics(int height, int width, int shootPartHeight, int shootPartWidth, Color enemyColor) {
        this.height=height;
        this.width=width;
        this.shootPartHeight=shootPartHeight;
        this.shootPartWidth=shootPartWidth;
        this.enemyColor=enemyColor;
    }

    public void setBulletGraphics(int height, int width, Color enemyColor){
        this.bulletHeight=height;
        this.bulletWidth=width;
        this.enemyColor=enemyColor;
    }

    public void setBulletSpeed(int speed){
        this.bulletSpeed=speed;
    }

    public static void clearEnemies(){
        enemies=new ArrayList<Enemy>();
    }
}
