package com.ab.buscardsystem.UILayer;

import com.ab.buscardsystem.BusinessLayer.Status;
import com.ab.buscardsystem.BusinessLayer.WholeSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddingMoneyToCenterFrame {
    private JPanel panel1;
    private JTextField centerIdTextField;
    private JTextField amountTextField;
    private JTextField paymentTextField;
    private JLabel centerIdLabel;
    private JLabel amountLabel;
    private JLabel paymentLabel;
    private JButton OKButton;
    private JButton cancelButton;
    private JPanel statusPanel;
    private JLabel statusText;
    private JLabel currentCenterBalance;
    private JFrame frame;

    public AddingMoneyToCenterFrame(){
        putActions();
    }

    private void putActions() {

        OKButton.addActionListener(ActionEvent -> {
            double payment = Double.parseDouble(paymentTextField.getText());
            double amount = Double.parseDouble(amountTextField.getText());
            int centerId = Integer.parseInt(centerIdTextField.getText());
            WholeSystem wholeSystem = new WholeSystem();
            Status correctless = wholeSystem.startAddingMoneyToCenter(centerId, amount, payment);
            if(correctless == Status.PAYMENTNOTENOUGH)
                JOptionPane.showMessageDialog(frame, "Payment is not enough.");
            else if(correctless == Status.CENTERNULL)
                JOptionPane.showMessageDialog(frame, "There is no Center for this ID.");
            else{
                statusText.setText("Payment: " + payment + " Amount: " + amount);
                currentCenterBalance.setText("Current Center Balance: " + wholeSystem.getCityCardConsole().getCenterConsole().getBalance());
                JOptionPane.showMessageDialog(frame, "Success!");
            }
        });

        cancelButton.addActionListener( ActionEvent -> {
            frame.setVisible(false);
            frame.dispose();
            CityCardConsoleFrame cityCardConsoleFrame = new CityCardConsoleFrame();
            cityCardConsoleFrame.start();
        });
    }

    public void start(){
        frame = new JFrame("AddingMoneyToCenterFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AddingMoneyToCenterFrame");
        frame.setContentPane(new AddingMoneyToCenterFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }
}
