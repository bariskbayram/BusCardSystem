package com.ab.buscardsystem.UILayer;

import com.ab.buscardsystem.BusinessLayer.Status;
import com.ab.buscardsystem.BusinessLayer.WholeSystem;

import javax.swing.*;

public class AddingMoneyToCardFrame {
    private JPanel panel1;
    private JTextField cardIdTextField;
    private JTextField amountTextField;
    private JTextField paymentTextField;
    private JButton OKButton;
    private JButton cancelButton;
    private JLabel currentCardBalance;
    private JLabel statusText;
    private JLabel currentCenterBalance;
    private JFrame frame;
    private int centerId;

    public AddingMoneyToCardFrame() {
        putActions();
    }

    private void putActions() {

        OKButton.addActionListener( ActionEvent -> {
            double payment = Double.parseDouble(paymentTextField.getText());
            double amount = Double.parseDouble(amountTextField.getText());
            int cardId = Integer.parseInt(cardIdTextField.getText());
            WholeSystem wholeSystem = new WholeSystem();
            wholeSystem.setCenterId(centerId);
            wholeSystem.setCardId(cardId);
            Status correctless = wholeSystem.startAddingMoneyToCardFrame(amount, payment);
            if(correctless == Status.PAYMENTNOTENOUGH)
                JOptionPane.showMessageDialog(frame, "Payment is not enough.");
            else if(correctless == Status.NOTENOUGHBALANCE)
                JOptionPane.showMessageDialog(frame, "Center's balance is not enough.");
            else if(correctless == Status.CARDNULL)
                JOptionPane.showMessageDialog(frame, "There is no Card for this ID.");
            else{
                statusText.setText("Payment: " + payment + " Amount: " + amount);
                currentCardBalance.setText("Current Card Balance: " + wholeSystem.getCenterConsole().getCard().getBalance());
                currentCenterBalance.setText("Current Center Balance: " + wholeSystem.getCenterConsole().getBalance());
                JOptionPane.showMessageDialog(frame, "Success!");
            }
        });

        cancelButton.addActionListener( ActionEvent -> {
            frame.setVisible(false);
            frame.dispose();
            CenterConsoleFrame centerConsoleFrame = new CenterConsoleFrame();
            centerConsoleFrame.start();
        });
    }

    public void start(){
        frame = new JFrame("AddingMoneyToCardFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }

    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }
}
