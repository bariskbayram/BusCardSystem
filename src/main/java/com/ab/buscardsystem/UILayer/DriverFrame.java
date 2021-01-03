package com.ab.buscardsystem.UILayer;

import javax.swing.*;

public class DriverFrame {

    private JFrame frame;
    private JButton exitButton;
    private JPanel panel1;
    private JPanel CardPanel;
    private JButton studentButton;
    private JButton normalButton;
    private JButton campusButton;

    public DriverFrame() {
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("DriverFrame");
        frame.setContentPane(new DriverFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }


    public void start() {
        frame = new JFrame("DriverFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(100,150);
        frame.pack();
        frame.setVisible(true);
    }
}
