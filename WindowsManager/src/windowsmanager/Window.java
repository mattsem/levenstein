/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windowsmanager;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Matt
 */
public class Window {

    private int SIZE;

    private int xLow;

    private int yLow;
    private float color;

    public Window(int x, int y, int size, float color) {

        SIZE = size;

        this.color = color;
        xLow = x;
        yLow = y;

    }

    public int getSize() {
        return SIZE;
    }

    public float getColor() {
        return color;
    }

    public int getXLow() {
        return xLow;
    }

    public int getYLow() {
        return yLow;
    }

    public int getXHigh() {
        return (xLow + SIZE);
    }

    public int getYHigh() {
        return (yLow + SIZE);
    }

    public boolean inWindow(int x, int y) {
        if (x > getXLow() && x < getXHigh() && y > getYLow() && y < getYHigh()) {
            System.out.println("true");
            return true;

        } else {
            return false;
        }
    }

    public void draw(Graphics g) {
        g.setColor(Color.getHSBColor(color, 1.0f, 1.0f));
        g.fillRect(xLow, yLow, SIZE, SIZE);
    }

}
