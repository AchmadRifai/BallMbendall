/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballmbendall;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author oh
 */
public class GameFrame extends JFrame {
    private java.awt.Rectangle screen;
    private ballmbendall.anim.GameRunner gr;
    private ballmbendall.anim.GameManager gm;

    public GameFrame() throws HeadlessException {
        super();
        ichiban();
    }

    private void ichiban() {
        setLocation(Utils.fixedPos());
        screen = Utils.layar();
        setSize(screen.width, screen.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gm = new ballmbendall.anim.GameManager(screen);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                gameStart();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(screen.x, screen.y, screen.width, screen.height);
        gm.draw(g);
    }

    private void gameStart() {
        gr = new ballmbendall.anim.GameRunner(this);
        gr.start();
    }

    public void ubah() {
        gm.update();
    }
}
