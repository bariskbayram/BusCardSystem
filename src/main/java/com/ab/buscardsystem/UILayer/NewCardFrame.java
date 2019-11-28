package com.ab.buscardsystem.UILayer;

import com.ab.buscardsystem.BusinessLayer.CardType;
import com.ab.buscardsystem.BusinessLayer.Status;
import com.ab.buscardsystem.BusinessLayer.WholeSystem;

import javax.swing.*;

public class NewCardFrame {

    private JPanel panel1;
    private JButton GoBack;
    private JTextField enterNameTextField;
    private JTextField enterSurnameTextField;
    private JTextField enterCardIDTextField;
    private JComboBox selectTypeComboBox;
    private JButton ADDButton;
    private JLabel cardIdLabel;
    private JLabel nameLabel;
    private JLabel surnameLabel;
    private JLabel cardTypeLabel;
    private JFrame frame;

    public NewCardFrame(){
        putActions();
    }

    private void putActions() {

        CardType[] typeList = new CardType[]{CardType.STUDENT, CardType.NORMAL, CardType.YEAR65PLUS};
        DefaultComboBoxModel model = new DefaultComboBoxModel(typeList);
        selectTypeComboBox.setModel(model);

        ADDButton.addActionListener(ActionEvent -> {
            WholeSystem wholeSystem = new WholeSystem();
            String name = enterNameTextField.getText();
            String surname = enterSurnameTextField.getText();
            int cardId = Integer.parseInt(enterCardIDTextField.getText());
            CardType cardType = (CardType) selectTypeComboBox.getSelectedItem();
            Status correctness = wholeSystem.startAddingCard(cardId, name, surname, cardType);
            if(correctness == Status.CARDEXIST)
                JOptionPane.showMessageDialog(frame, "This Card ID is already exist.");
            else{
                cardIdLabel.setText("CardID: " + cardId);
                nameLabel.setText("Name: " + name);
                surnameLabel.setText("Surname: " + surname);
                cardTypeLabel.setText("CardType: " + cardType);
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
        frame = new JFrame("NewCardFrame");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(400,150);
        frame.pack();
        frame.setVisible(true);
    }
}
