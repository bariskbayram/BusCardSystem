package com.ab.buscardsystem.UILayer;

import javax.swing.*;

public class TappingCardFrame {
    private JPanel panel1;
    private JTextField enterCardIdTextField;
    private JButton OKButton;
    private JLabel enterCardIdLabel;
    private JFrame frame;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TappingCardFrame");
        frame.setContentPane(new TappingCardFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public void start() {
        frame = new JFrame("TappingCardFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(700,150);
        frame.pack();
        frame.setVisible(true);
    }
}
