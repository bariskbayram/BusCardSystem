package com.ab.buscardsystem;

import java.sql.PreparedStatement;

public class DriverDB implements IDataBase {

    private SqliteDB sqliteDB;
    private Driver driver;

    public DriverDB(SqliteDB sqliteDB){
        this.sqliteDB = sqliteDB;
    }

    @Override
    public Object getItem(int id) {
        return null;
    }

    @Override
    public void deleteItem(int id) {
        try {
            sqliteDB.connectDB();
            String queryDelete = "DELETE FROM Driver WHERE Id = ?";
            PreparedStatement preparedStatementDelete = sqliteDB.connection.prepareStatement(queryDelete);
            preparedStatementDelete.setString(1,String.valueOf(id));
            preparedStatementDelete.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateItem(ParentObject object) {}

    @Override
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            String query = "INSERT INTO Driver (Id, Name, Surname) VALUES (?,?,?)";
            PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
            Driver driver = (Driver) object;
            preparedStatement.setString(1, String.valueOf(driver.getId()));
            preparedStatement.setString(2, String.valueOf(driver.getName()));
            preparedStatement.setString(3, String.valueOf(driver.getSurname()));
            preparedStatement.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public SqliteDB getSqliteDB() {
        return sqliteDB;
    }
    public void setSqliteDB(SqliteDB sqliteDB) {
        this.sqliteDB = sqliteDB;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

}
