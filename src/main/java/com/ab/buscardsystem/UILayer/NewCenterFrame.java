package com.ab.buscardsystem.UILayer;

import javax.swing.*;

public class NewCenterFrame {
    private JPanel panel1;
    private JButton GoBack;
    private JFrame frame;

    public NewCenterFrame(){
        putActions();
    }

    private void putActions() {

        GoBack.addActionListener( ActionEvent -> {
            frame.setVisible(false);
            frame.dispose();
            CityCardConsoleFrame cityCardConsoleFrame = new CityCardConsoleFrame();
            cityCardConsoleFrame.start();
        });
    }

    public void start(){
        frame = new JFrame("NewCenterFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("NewCenterFrame");
        frame.setContentPane(new NewCenterFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
