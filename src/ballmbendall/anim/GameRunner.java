/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballmbendall.anim;

import ballmbendall.GameFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author oh
 */
public class GameRunner extends Thread {
    private GameFrame gf;
    private boolean running, skip;
    private int fps;

    public GameRunner(GameFrame gf) {
        super();
        this.gf = gf;
        running = true;
        skip = false;
        fps = 100;
    }

    @Override
    public void run() {
        while (running) {
            if (skip) return;
            eksekusi();
        }
    }

    private void eksekusi() {
        gf.ubah();
        gf.repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameRunner.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
