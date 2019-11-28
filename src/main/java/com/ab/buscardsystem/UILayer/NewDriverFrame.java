package com.ab.buscardsystem.UILayer;

import com.ab.buscardsystem.BusinessLayer.Status;
import com.ab.buscardsystem.BusinessLayer.WholeSystem;

import javax.swing.*;

public class NewDriverFrame {
    private JPanel panel1;
    private JButton GoBack;
    private JTextField enterNameTextField;
    private JTextField enterSurnameTextField;
    private JTextField enterDriverIDTextField;
    private JLabel driverIdLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JButton ADDButton;
    private JFrame frame;

    public NewDriverFrame(){
        putActions();
    }

    private void putActions() {

        ADDButton.addActionListener(ActionEvent -> {
            String name = enterNameTextField.getText();
            String surname = enterSurnameTextField.getText();
            int driverId = Integer.parseInt(enterDriverIDTextField.getText());
            WholeSystem wholeSystem = new WholeSystem();
            Status correctness = wholeSystem.startAddingDriver(name, surname, driverId);
            if(correctness == Status.DRIVEREXIST)
                JOptionPane.showMessageDialog(frame, "This Driver ID is already exist.");
            else{
                driverIdLabel.setText("DriverID: " + driverId);
                nameLabel.setText("Name: " + name);
                surnameLabel.setText("Surname: " + surname);
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
        frame = new JFrame("NewDriverFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }
}
