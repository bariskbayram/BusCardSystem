package com.ab.buscardsystem.UILayer;

import com.ab.buscardsystem.BusinessLayer.Status;
import com.ab.buscardsystem.BusinessLayer.WholeSystem;

import javax.swing.*;

public class NewCenterFrame {
    private JPanel panel1;
    private JButton GoBack;
    private JTextField enterNameTextField;
    private JTextField enterCenterIDTextField;
    private JLabel centerIdLabel;
    private JLabel nameLabel;
    private JButton ADDButton;
    private JTextField enterAddressTextField;
    private JLabel addressLabel;
    private JFrame frame;

    public NewCenterFrame(){
        putActions();
    }

    private void putActions() {

        ADDButton.addActionListener(ActionEvent -> {
            String name = enterNameTextField.getText();
            String address = enterAddressTextField.getText();
            int centerId = Integer.parseInt(enterCenterIDTextField.getText());
            WholeSystem wholeSystem = new WholeSystem();
            Status correctness = wholeSystem.startAddingCenter(name, address, centerId);
            if(correctness == Status.CENTEREXIST)
                JOptionPane.showMessageDialog(frame, "This Center ID is already exist.");
            else{
                nameLabel.setText("Name: " + name);
                addressLabel.setText("Address: " + address);
                centerIdLabel.setText("CenterID: " + centerId);
                JOptionPane.showMessageDialog(frame, "Success!");
            }
        });

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
}
