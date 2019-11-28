package com.ab.buscardsystem.UILayer;

import com.ab.buscardsystem.BusinessLayer.Status;
import com.ab.buscardsystem.BusinessLayer.WholeSystem;

import javax.swing.*;

public class DeleteCenterFrame {
    private JPanel panel1;
    private JButton GoBack;
    private JTextField enterCenterIDTextField;
    private JLabel centerIdLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JButton DELETEButton;
    private JFrame frame;

    public DeleteCenterFrame(){
        putActions();
    }

    private void putActions() {

        DELETEButton.addActionListener( ActionEvent -> {
            int centerId = Integer.parseInt(enterCenterIDTextField.getText());
            WholeSystem wholeSystem = new WholeSystem();
            Status correctness = wholeSystem.startRemovingCenter(centerId);
            if(correctness == Status.CENTERNOTEXIST)
                JOptionPane.showMessageDialog(frame, "Couldn't find a Center for this ID.");
            else{
                centerIdLabel.setText("CenterID: " + centerId);
                nameLabel.setText("Name: " + wholeSystem.getCenterConsole().getName());
                surnameLabel.setText("Address: " + wholeSystem.getCenterConsole().getAddress());
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
        frame = new JFrame("DeleteCenterFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }
}
