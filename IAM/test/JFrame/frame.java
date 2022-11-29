package test.JFrame;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.*;


public class frame implements KeyListener{
    private JFrame jframe;
    JTextField typingArea=new JTextField();
    public frame(){
    }
    public void run(){
        this.jframe=new JFrame("First Window");
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(500, 500);
        System.out.println("Frame is focusable: "+jframe.isFocusable());
        jframe.getContentPane().addKeyListener(this);   //Not working as intended
        jframe.setVisible(true);    
    }
    @Override
    public void keyPressed(KeyEvent e){
        System.out.println(e);
    }
    public void keyTyped(KeyEvent e){
        System.out.println(e);
    }
    public void keyReleased(KeyEvent e){
        System.out.println(e);
    }
}