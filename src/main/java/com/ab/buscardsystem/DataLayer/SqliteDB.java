package com.ab.buscardsystem.DataLayer;

import java.sql.*;

public class SqliteDB {

    private Connection connection = null;

    SqliteDB(){
    }

    public void connectDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:BusCardSystemDB");
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void closeDB(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
