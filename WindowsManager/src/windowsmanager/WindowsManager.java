/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package windowsmanager;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Matt
 */
public class WindowsManager extends javax.swing.JFrame implements MouseListener {

    private ArrayList<Window> array = new ArrayList<Window>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        WindowsManager app = new WindowsManager();
        app.run();
    }

    public WindowsManager() {

        addWindow();
        addWindow();
        addWindow();
        addWindow();
        addWindow();

    }

    public void addWindow() {
        Random rand = new Random();

        int size = rand.nextInt(300) + 100;
        float color = rand.nextFloat();
        int x = rand.nextInt(400) + 10;
        int y = rand.nextInt(400) + 10;

        Window window = new Window(x, y, size, color);

        array.add(window);

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        drawAll(g);

    }

    public void run() {
        this.setBounds(0, 0, 800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.setBackground(Color.white);

        this.addMouseListener(this);

        while (true);
    }

    public void drawAll(Graphics g) {

        for (int i = 0; i < array.size(); i++) {
            array.get(i).draw(g);
        }

    }

    public int whichWindow(int x, int y) {

        for (int i = array.size() - 1; i >= 0; i--) {
            if (array.get(i).inWindow(x, y) == true) {
                return i;
            }

        }

        return -1;
    }

    public void bringFront(int num) {

        Window w = array.get(num);

        array.remove(num);

        array.add(w);
        this.invalidate();
        this.repaint();

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("mouse clicked");
        int winNum = whichWindow(me.getX(), me.getY());
        if (winNum != -1) {
            bringFront(winNum);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        System.out.println("mouse pressed");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        System.out.println("mouse released");
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        System.out.println("mouse entered");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        System.out.println("mouse exit");
    }

}
