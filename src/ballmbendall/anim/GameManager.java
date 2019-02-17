/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballmbendall.anim;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.List;

/**
 *
 * @author oh
 */
public class GameManager {
    private Rectangle screen;
    private List<Point> bintang;
    private List<java.awt.Rectangle> tanah;
    private int speed;

    public GameManager(Rectangle screen) {
        super();
        this.screen = screen;
        ichiban();
    }

    private void ichiban() {
        speed = screen.width / 20;
        bintang = new java.util.LinkedList<>();
        new Thread(()->{ buatBintang(); }).start();
        buatTanah();
    }

    private void buatBintang() {
        int minX = screen.x, minY = screen.y, maxX = screen.width, maxY = screen.height;
        for (int i = 0; i < 250; i++) {
            int x = acak(minX, maxX), y = acak(minY, maxY);
            java.awt.Point p = new java.awt.Point(x, y);
            while (bintang.contains(p)) {
                x = acak(minX, maxX);
                y = acak(minY, maxY);
                p = new java.awt.Point(x, y);
            } bintang.add(p);
        }
    }

    private int acak(int min, int max) {
        java.util.Random r = new java.util.Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        for (Point p : bintang)
            g.drawLine(p.x, p.y, p.x, p.y);
        for (java.awt.Rectangle r : tanah) {
            g.setColor(Color.decode("#8B4513"));
            g.fillRect(r.x, r.y, r.width, r.height);
            g.setColor(Color.BLACK);
            g.drawRect(r.x, r.y, r.width, r.height);
        } 
    }

    private void buatTanah() {
        tanah = new java.util.LinkedList<>();
        int width = screen.width / 10, height = screen.height / 10;
        for (int i = 0; i < 12; i++) {
            java.awt.Rectangle r1 = new java.awt.Rectangle(0, (screen.height * 2) / 3, width, height);
            if (i > 0) {
                java.awt.Rectangle r = tanah.get(i - 1);
                r1.x = r.x + r.width;
            } tanah.add(r1);
        }
    }

    public void update() {
        tanahUpdate();
    }

    private void tanahUpdate() {
        boolean re = false;
        for (int i = 0; i < tanah.size(); i++) {
            java.awt.Rectangle r = tanah.get(i);
            r.x = r.x - speed;
            if (i == tanah.size() - 1 && re) {
                int width = screen.width / 10, height = screen.height / 10;
                java.awt.Rectangle r1 = new java.awt.Rectangle(r.x + r.width, (screen.height * 2) / 3, width, height);
                tanah.add(r1);
                tanah.remove(0);
            } else if (i == 0)
                re = 0 >= r.x + r.width;
        }
    }
}
