package com.ab.buscardsystem.UILayer;

import com.ab.buscardsystem.BusinessLayer.WholeSystem;

import javax.swing.*;

public class CenterConsoleFrame {
    private JPanel panel1;
    private JButton logInButton;
    private JTextField enterCenterIdTextField;
    private JButton goBackButton;
    private JFrame frame;

    public CenterConsoleFrame() {
        putActions();
    }

    private void putActions() {
        logInButton.addActionListener(ActionEvent ->{
            WholeSystem wholeSystem = new WholeSystem();
            int centerID = Integer.parseInt(enterCenterIdTextField.getText());
            wholeSystem.setCenterId(centerID);
            if(!wholeSystem.startInputCenterConsoleFrame()){
                JOptionPane.showMessageDialog(frame, "There is no Center for this ID.");
            }else {
                frame.setVisible(false);
                frame.dispose();
                AddingMoneyToCardFrame addingMoneyToCardFrame = new AddingMoneyToCardFrame();
                addingMoneyToCardFrame.start();
                addingMoneyToCardFrame.setCenterId(centerID);
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
        frame = new JFrame("CenterConsoleFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }
}
