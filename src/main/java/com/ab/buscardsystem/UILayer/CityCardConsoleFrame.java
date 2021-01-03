package com.ab.buscardsystem.UILayer;

import javax.swing.*;

public class CityCardConsoleFrame extends JFrame {

    private JPanel panel1;
    private JButton addNewCardButton;
    private JButton addCenterButton;
    private JButton addDriverButton;
    private JButton addMoneyToCenterButton;
    private JButton deleteDriverButton;
    private JButton deleteCenterButton;
    private JButton goBackButton;
    private JFrame frame;

    public CityCardConsoleFrame() {
        putActions();
    }

    private void putActions() {
        addNewCardButton.addActionListener(ActionEvent -> {
            frame.setVisible(false);
            frame.dispose();
            NewCardFrame newCardFrame = new NewCardFrame();
            newCardFrame.start();
        });

        addCenterButton.addActionListener(ActionEvent -> {
            frame.setVisible(false);
            frame.dispose();
            NewCenterFrame newCenterFrame = new NewCenterFrame();
            newCenterFrame.start();
        });

        addDriverButton.addActionListener(ActionEvent -> {
            frame.setVisible(false);
            frame.dispose();
            NewDriverFrame newDriverFrame = new NewDriverFrame();
            newDriverFrame.start();
        });

        addMoneyToCenterButton.addActionListener(ActionEvent -> {
            frame.setVisible(false);
            frame.dispose();
            AddingMoneyToCenterFrame addingMoneyToCenterFrame = new AddingMoneyToCenterFrame();
            addingMoneyToCenterFrame.start();
        });

        deleteDriverButton.addActionListener(ActionEvent -> {
            frame.setVisible(false);
            frame.dispose();
            DeleteDriverFrame deleteDriverFrame = new DeleteDriverFrame();
            deleteDriverFrame.start();
        });

        deleteCenterButton.addActionListener(ActionEvent -> {
            frame.setVisible(false);
            frame.dispose();
            DeleteCenterFrame deleteCenterFrame = new DeleteCenterFrame();
            deleteCenterFrame.start();
        });

        goBackButton.addActionListener(ActionEvent -> {
            frame.setVisible(false);
            frame.dispose();
            StarterFrame starterFrame = new StarterFrame();
            starterFrame.setVisible(true);
        });
    }

    public void start() {
        frame = new JFrame("CityCardConsoleFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }

}
