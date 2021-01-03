package com.ab.buscardsystem.UILayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class StarterFrame extends JFrame {

    private JButton busConsoleButton = new JButton("Bus Console");
    private JButton centerConsoleButton = new JButton("Center Console");
    private JButton cityCardConsoleButton = new JButton("City Card Console");
    private JButton cancelButton = new JButton("Cancel");
    private JLabel appLabel = new JLabel("BUS CARD SYSTEM", JLabel.CENTER);
    private JPanel panel;


    public StarterFrame(){
        setBounds(400,150,580,360);
        setLayout(new GridLayout(3,3,100,20));
        panel = new JPanel(new GridLayout(1,3,5,5));
        add(appLabel);
        putButtons();
        add(panel);
        this.add(cancelButton);
        getActions();
    }

    public static void main(String[] args){
        StarterFrame starterFrame = new StarterFrame();
        starterFrame.setVisible(true);
    }

    private void putButtons() {
        panel.add(busConsoleButton);
        panel.add(centerConsoleButton);
        panel.add(cityCardConsoleButton);
    }

    private void getActions() {
        busConsoleButton.addActionListener( ActionEvent -> {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            DriverLogInFrame driverLogInFrame = new DriverLogInFrame();
            driverLogInFrame.start();
        });
        centerConsoleButton.addActionListener( ActionEvent -> {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            CenterConsoleFrame centerConsoleFrame = new CenterConsoleFrame();
            centerConsoleFrame.start();
        });
        cityCardConsoleButton.addActionListener( ActionEvent -> {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            CityCardConsoleFrame cityCardConsoleFrame = new CityCardConsoleFrame();
            cityCardConsoleFrame.start();
        });
        cancelButton.addActionListener( ActionEvent -> {
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
            System.exit(0);
        } );
    }
}
