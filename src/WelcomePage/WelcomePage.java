/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WelcomePage;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Rupesh
 */
public class WelcomePage extends JFrame  {
    
    JLabel drawstr;
    
    public WelcomePage(){
        
        this.setSize(300,300);
        this.setTitle("Welcome Page ");
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
         Toolkit toolkit = this.getToolkit();
        Dimension size = toolkit.getScreenSize();
      int   widthscreen = (int) ((size.getWidth() - this.getWidth()) / 2);
        int heightscreen = (int) ((size.getHeight() - this.getHeight()) / 2);
      
        this.setLocation(widthscreen , heightscreen);
        drawstr=new JLabel("Welcom Guys");
        drawstr.setFont(new Font("Arial",Font.BOLD,20));
        
        add(drawstr);
        
    }
    
}
