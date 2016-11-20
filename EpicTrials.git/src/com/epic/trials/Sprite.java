package com.epic.trials;

import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;
import java.awt.Rectangle;

public class Sprite
{
    private Resources.SpriteType type;
    private int dx;
    private int dy;
    private final int width;
    private final int height;
    private int x;
    private int y;
    private Image image;

    public Sprite() {
        type = Resources.SpriteType.PLATFORM;
        width = 0;
        height = 0;
        x = 0;
        y = 0;
        image = null;
    }

    public Sprite(Resources.SpriteType type, ImageIcon image)
    {
        this.type = type;
        this.image = image.getImage();
        this.width = image.getIconWidth();
        this.height = image.getIconHeight();
        this.x = 0;
        this.y = 0;
    }

    public Sprite(Resources.SpriteType type, int width, int height, int x, int y, ImageIcon image) {
        this.type = type;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.image = image.getImage();
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public Resources.SpriteType getType()
    {
        return type;
    }
    public Image getImage()
    {
        return image;
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }

    public void move()
    {
        if (type == Resources.SpriteType.PLAYER || type == Resources.SpriteType.ENEMY)
        {
            x += dx;
            y += dy;

            if (x < 1)
            {
                x = 1;
            }

            if (y < 1)
            {
                y = 1;
            }
        }
    }

    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();

        switch (key)
        {
            case KeyEvent.VK_LEFT:
                dx = -1;
                break;
            case KeyEvent.VK_RIGHT:
                dx = 1;
                break;
            default:
                return;
        }

    }

    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();

        switch (key)
        {
            case KeyEvent.VK_LEFT:
                dx = 0;
                break;
            case KeyEvent.VK_RIGHT:
                dx = 0;
                break;
            default:
                return;
        }
    }
}
