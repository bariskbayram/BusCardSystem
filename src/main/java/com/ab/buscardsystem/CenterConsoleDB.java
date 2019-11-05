package com.ab.buscardsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CenterConsoleDB implements IDataBase {

    private SqliteDB sqliteDB;
    private CenterConsole centerConsole;

    public CenterConsoleDB(SqliteDB sqliteDB){
        this.sqliteDB = sqliteDB;
    }

    @Override
    public Object getItem(int id) {
        try {
            sqliteDB.connectDB();
            String query = "SELECT * FROM CenterConsole WHERE Id = ?";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            preparedStatement.setString(1,String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                CenterConsole centerConsole = new CenterConsole();
                centerConsole.setId(resultSet.getInt("Id"));
                if(centerConsole.getId() < 0 || centerConsole.getId() > 10000 || centerConsole.getId() != id)
                    return null;
                centerConsole.setBalance(resultSet.getDouble("Balance"));
                this.centerConsole = centerConsole;
            }
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
        return centerConsole;
    }

    @Override
    public void deleteItem(int id) {
        try {
            sqliteDB.connectDB();
            String queryDelete = "DELETE FROM CenterConsole WHERE Id = ?";
            PreparedStatement preparedStatementDelete = sqliteDB.getConnection().prepareStatement(queryDelete);
            preparedStatementDelete.setString(1,String.valueOf(id));
            preparedStatementDelete.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void updateItem(ParentObject object) {
        try{
            sqliteDB.connectDB();
            centerConsole = (CenterConsole) object;
            String query = "UPDATE CenterConsole SET Balance = ? WHERE Id = ?";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(centerConsole.getBalance()));
            preparedStatement.setString(2, String.valueOf(centerConsole.getId()));
            preparedStatement.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            CenterConsole centerConsole = (CenterConsole) object;
            String query = "INSERT INTO CenterConsole (Id, Name, Address, Balance) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(centerConsole.getId()));
            preparedStatement.setString(2, String.valueOf(centerConsole.getName()));
            preparedStatement.setString(3, String.valueOf(centerConsole.getAddress()));
            preparedStatement.setString(4, String.valueOf(centerConsole.getBalance()));
            preparedStatement.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
