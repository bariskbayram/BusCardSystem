package com.ab.buscardsystem;

import java.sql.SQLException;
import java.time.LocalTime;

public class Starter {

    public static void main(String[] args) throws SQLException {

        WholeSystem start = new WholeSystem();
        start.start();

        /*String find = "Allah";
        String query1 = "INSERT INTO Card (Name, Surname, Bakiye) VALUES ('Allah', 'ü-teala', 999)";
        SqliteDB sqliteDB = new SqliteDB();

        sqliteDB.listCards();

        String query2 = "DELETE FROM Card WHERE Name = ?";
        PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query2);
        preparedStatement.setString(1,find);
        preparedStatement.executeUpdate();

        sqliteDB.listCards();

        sqliteDB.executeQuery(query1);

        sqliteDB.listCards();

        sqliteDB.closeDB();*/

    }
}
