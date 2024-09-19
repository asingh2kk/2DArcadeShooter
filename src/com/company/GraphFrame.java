package com.company;

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GraphFrame extends JFrame implements KeyListener
{
    private GraphPanel frame;

    @Override
    public void repaint()
    {
        super.repaint();
    }
    public GraphFrame()
    {
        super();
        frame = new GraphPanel();
        add(frame);
        pack();
        addKeyListener(this);
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        frame.keyPressed(e);
        //repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }

    public void endGame(){
        frame.endGame();
    }
}
