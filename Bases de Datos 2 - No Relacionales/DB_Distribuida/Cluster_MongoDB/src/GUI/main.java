package GUI;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author bryan
 */
public class main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
                
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        principal database = new principal();
        database.setVisible(true);
    }
}
