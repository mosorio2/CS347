package com.epic.trials;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Board extends JPanel implements ActionListener {

    private Sprite player;

    public Board() {
        initBoard();
    }

    private void initBoard()
    {
        addKeyListener(new TAdapter());
        setFocusable(true);

        player = new Sprite(Resources.SpriteType.PLAYER, new ImageIcon("../res/Hero80x80.png"));
        player.setX(40);
        player.setY(40);
        System.out.println("X: "+ player.getX() + " Y: " + player.getY());
		
		setPreferredSize(new Dimension(800, 600));
		//setBackground(Color.BLUE);
		setOpaque(true);
		setVisible(true);
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        doDrawing(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void doDrawing(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), this);
    }

    public void actionPerformed(ActionEvent e)
    {
        player.move();
        repaint();
    }

    private class TAdapter extends KeyAdapter {
        public void keyReleased(KeyEvent e)
        {
            player.keyReleased(e);
        }

        public void keyPressed(KeyEvent e)
        {
            player.keyPressed(e);
        }
    }

}
