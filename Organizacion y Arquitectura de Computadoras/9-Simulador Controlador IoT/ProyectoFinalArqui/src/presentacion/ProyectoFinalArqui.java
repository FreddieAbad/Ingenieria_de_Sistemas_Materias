package presentacion;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author bryan
 */
public class ProyectoFinalArqui {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        interfazALU principal = new interfazALU();
        principal.setLocationRelativeTo(null);
        principal.setVisible(true);
    }
}
