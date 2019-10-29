package com.ab.buscardsystem;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Starter {

    public static void main(String[] args) throws SQLException {

        WholeSystem start = new WholeSystem();
        System.out.println("Bütün sistem oluşturuldu: " + start);
        start.start();

        String find = "Allah";
        String query1 = "INSERT INTO Card (Name, Surname, Bakiye) VALUES ('Zillah', 'ü-teala', 999)";
        SqliteDB sqliteDB = new SqliteDB();


        String query2 = "DELETE FROM Card WHERE Name = ?";
        PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query2);
        preparedStatement.setString(1,find);
        preparedStatement.executeUpdate();


        sqliteDB.listCards();

        sqliteDB.executeQuery(query1);

        sqliteDB.listCards();


        sqliteDB.closeDB();

    }
}
