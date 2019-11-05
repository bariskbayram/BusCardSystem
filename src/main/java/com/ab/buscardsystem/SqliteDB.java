package com.ab.buscardsystem;

import java.sql.*;

public class SqliteDB {

    private Connection connection = null;
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
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    public Statement getStatement() {
        return statement;
    }
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

}
