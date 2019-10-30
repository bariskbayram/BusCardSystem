package com.ab.buscardsystem;

import java.sql.SQLException;

public class Starter {

    public static void main(String[] args) throws SQLException {

        WholeSystem start = new WholeSystem();
        //start.startTappingCard();
        //start.startDepositToCard();
        start.startDepositToDepositCenter();

    }
}
