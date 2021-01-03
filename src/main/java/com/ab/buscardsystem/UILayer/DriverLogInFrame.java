package com.ab.buscardsystem.UILayer;

import com.ab.buscardsystem.BusinessLayer.WholeSystem;

import javax.swing.*;

public class DriverLogInFrame {

    private JPanel panel1;
    private JComboBox busConsoleIDComboBox;
    private JTextField driverIDTextField;
    private JButton logInButton;
    private JButton goBackButton;
    private JFrame frame;

    public DriverLogInFrame() {
        putActions();
    }

    private void putActions() {

        String[] busList = new String[]{"1", "2", "3"};
        DefaultComboBoxModel model = new DefaultComboBoxModel(busList);
        busConsoleIDComboBox.setModel(model);

        logInButton.addActionListener( ActionEvent -> {
            WholeSystem wholeSystem = new WholeSystem();
            busConsoleIDComboBox.getSelectedItem();
            boolean isCorretDriverId = wholeSystem.startDriverLogIn(Integer.parseInt(driverIDTextField.getText()),
                                         Integer.parseInt((String) busConsoleIDComboBox.getSelectedItem()));
            if(!isCorretDriverId) {
                JOptionPane.showMessageDialog(frame, "There is no Driver for this ID.");
            }else{
                frame.setVisible(false);
                frame.dispose();
                DriverFrame driverFrame = new DriverFrame();
                driverFrame.start();
                TappingCardFrame tappingCardFrame = new TappingCardFrame();
                tappingCardFrame.start();
            }
        });

        goBackButton.addActionListener( ActionEvent -> {
            frame.setVisible(false);
            frame.dispose();
            StarterFrame starterFrame = new StarterFrame();
            starterFrame.setVisible(true);
        });
    }

    public void start() {
        frame = new JFrame("BusConsoleFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }
}
