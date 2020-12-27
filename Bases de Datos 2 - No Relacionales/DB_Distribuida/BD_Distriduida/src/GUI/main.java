/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class main {
    
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
                
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        mainWindow database = new mainWindow();
        database.setVisible(true);
    }
}
