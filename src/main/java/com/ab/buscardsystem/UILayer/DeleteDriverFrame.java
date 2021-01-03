package com.ab.buscardsystem.UILayer;

import com.ab.buscardsystem.BusinessLayer.Status;
import com.ab.buscardsystem.BusinessLayer.WholeSystem;

import javax.swing.*;

public class DeleteDriverFrame {
    private JPanel panel1;
    private JButton GoBack;
    private JTextField enterDriverIDTextField;
    private JLabel driverIdLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JButton DELETEButton;
    private JFrame frame;

    public DeleteDriverFrame(){
        putActions();
    }

    private void putActions() {

        DELETEButton.addActionListener( ActionEvent -> {
            int driverId = Integer.parseInt(enterDriverIDTextField.getText());
            WholeSystem wholeSystem = new WholeSystem();
            Status correctness = wholeSystem.startRemovingDriver(driverId);
            if(correctness == Status.DRIVERNOTEXIST)
                JOptionPane.showMessageDialog(frame, "Couldn't find a Driver for this ID.");
            else{
                driverIdLabel.setText("DriverID: " + driverId);
                nameLabel.setText("Name: " + wholeSystem.getDriver().getName());
                surnameLabel.setText("Surname: " + wholeSystem.getDriver().getSurname());
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
        frame = new JFrame("DeleteDriverFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }
}
