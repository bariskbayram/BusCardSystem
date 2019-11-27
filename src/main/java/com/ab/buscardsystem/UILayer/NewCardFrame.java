package com.ab.buscardsystem.UILayer;

import com.ab.buscardsystem.BusinessLayer.CardType;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class NewCardFrame {

    private JPanel panel1;
    private JButton GoBack;
    private JTextField enterNameTextField;
    private JTextField enterSurnameTextField;
    private JTextField enterCardIDTextField;
    private JComboBox selectTypeComboBox;
    private JButton ADDButton;
    private JFrame frame;

    public NewCardFrame(){
        putActions();
    }

    private void putActions() {

        CardType[] typeList = new CardType[]{CardType.STUDENT, CardType.NORMAL, CardType.YEAR65PLUS};
        DefaultComboBoxModel model = new DefaultComboBoxModel(typeList);
        selectTypeComboBox.setModel(model);

        ADDButton.addActionListener(ActionEvent -> {
            String name = enterNameTextField.getText();
            String surname = enterSurnameTextField.getText();
            int cardId = Integer.parseInt(enterCardIDTextField.getText());
            CardType cardType = (CardType) selectTypeComboBox.getSelectedItem();



        });

        GoBack.addActionListener( ActionEvent -> {
            frame.setVisible(false);
            frame.dispose();
            CityCardConsoleFrame cityCardConsoleFrame = new CityCardConsoleFrame();
            cityCardConsoleFrame.start();
        });
    }

    public void start(){
        frame = new JFrame("NewCardFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("NewCardFrame");
        frame.setContentPane(new NewCardFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
