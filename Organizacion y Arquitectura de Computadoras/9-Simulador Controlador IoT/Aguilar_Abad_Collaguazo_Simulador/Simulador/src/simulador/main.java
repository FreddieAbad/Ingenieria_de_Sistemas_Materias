package simulador;

import interfaz.Interfaz;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        Interfaz principal = new Interfaz();
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
}
