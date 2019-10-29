package com.ab.buscardsystem;

import java.sql.*;

public class SqliteDB {

    Connection connection = null;
    Statement statement = null;

    SqliteDB(){
    }

    public void connectDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:BusCardSystemDB");
            System.out.println("Connected to DB OK!");
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void executeQuery(String query){
        try {
            this.statement = connection.createStatement();
            statement.executeQuery(query);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void closeDB(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
