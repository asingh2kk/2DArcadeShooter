package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main {

    public static GraphFrame gameFrame;

    public static void main(String[] args) {
        titleScreen();
    }

    public static void startGame(){
        Player.resetPlayer();
        Enemy.clearEnemies();
        GraphFrame frame = new GraphFrame();
        gameFrame=frame;
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Basic shooting game");
        frame.setVisible(true);
    }

    public static void titleScreen(){
        JFrame frame= new JFrame();
        frame.setTitle("Title Screen");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JButton jbutton=new JButton("Start Game");
        jbutton.addActionListener(e -> {
            startGame();
            frame.dispose();
        });

        frame.add(jbutton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void deathScreen(){
        JFrame frame= new JFrame();
        frame.setTitle("Death Screen");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JButton jbutton=new JButton("Restart?");
        jbutton.addActionListener(e -> {
            startGame();
            frame.dispose();
        });

        frame.add(jbutton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void winScreen(){
        JFrame frame= new JFrame();
        frame.setTitle("Win Screen");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);

        JButton jbutton=new JButton("Play Again?");
        jbutton.addActionListener(e -> {
            startGame();
            frame.dispose();
        });

        frame.add(jbutton);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void endGame(){
        gameFrame.endGame();
        gameFrame.dispose();
        deathScreen();
    }

    public static void winGame(){
        gameFrame.endGame();
        gameFrame.dispose();
        winScreen();
    }
}
