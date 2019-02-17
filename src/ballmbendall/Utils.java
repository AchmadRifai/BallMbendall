/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ballmbendall;

import java.awt.Point;
import java.awt.Rectangle;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author oh
 */
public class Utils {

    static void styling() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String os = System.getProperty("os.name");
        if (os.contains("Windows")) style("Windows");
        else if (os.contains("Linux")) style("GTK+");
        else style("Nimbus");
    }

    private static void style(String s) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        for (UIManager.LookAndFeelInfo i : UIManager.getInstalledLookAndFeels()) 
            if (s == null ? i.getName() == null : s.equals(i.getName())) {
            UIManager.setLookAndFeel(i.getClassName());
            break;
        }
    }

    static Point fixedPos() {
        return new Point(100, 100);
    }

    static Rectangle layar() {
        return new Rectangle(0, 0, 400, 600);
    }
    
}
