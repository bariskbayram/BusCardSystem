package com.ab.buscardsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DriverDB implements IDataBase {

    private SqliteDB sqliteDB;
    private Driver driver;

    public DriverDB(SqliteDB sqliteDB){
        this.sqliteDB = sqliteDB;
    }

    @Override
    public Object getItem(int id) {
        try {
            sqliteDB.connectDB();
            String query = "SELECT * FROM Driver WHERE Id = ?";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int driverId = resultSet.getInt("Id");
                Driver driver = new Driver(driverId);
                driver.setName(resultSet.getString("Name"));
                driver.setSurname(resultSet.getString("Surname"));
                this.driver = driver;
            }
            sqliteDB.closeDB();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    @Override
    public void deleteItem(int id) {
        try {
            sqliteDB.connectDB();
            String queryDelete = "DELETE FROM Driver WHERE Id = ?";
            PreparedStatement preparedStatementDelete = sqliteDB.getConnection().prepareStatement(queryDelete);
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
            Driver driver = (Driver) object;
            String query = "INSERT INTO Driver (Id, Name, Surname) VALUES (?,?,?)";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
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
