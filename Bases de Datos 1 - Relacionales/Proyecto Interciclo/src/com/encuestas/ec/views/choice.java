/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encuestas.ec.views;
import java.awt.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*; 
/**
 *
 * @author Freddie
 */
public class choice implements ItemListener {
    static Choice c;
    static JFrame f;
    public choice() {
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println(e.getItem().toString());
        System.out.println(">"+e.getItemSelectable().toString());
    }

}
