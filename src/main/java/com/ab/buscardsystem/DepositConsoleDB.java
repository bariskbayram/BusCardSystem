package com.ab.buscardsystem;

import java.sql.PreparedStatement;

public class DepositConsoleDB implements IDataBase {

    private SqliteDB sqliteDB;
    //private DepositConsole depositConsole;

    public DepositConsoleDB(SqliteDB sqliteDB){
        this.sqliteDB = sqliteDB;
    }

    @Override
    public Object getItem(int id) {
        return null;
    }

    @Override
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            DepositConsole depositConsole = (DepositConsole) object;
            String queryDelete = "DELETE FROM DepositConsole WHERE Id = ?"; //Eğer olmayan kart ekleme senaryosu çalışırsa delete sorun çıkarabilir.
            PreparedStatement preparedStatementDelete = sqliteDB.connection.prepareStatement(queryDelete);
            preparedStatementDelete.setString(1,String.valueOf(depositConsole.getDepositConsoleId()));
            preparedStatementDelete.executeUpdate();
            String query = "INSERT INTO DepositConsole (Id, Balance) VALUES (?,?)";
            PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(depositConsole.getDepositConsoleId()));
            preparedStatement.setString(2, String.valueOf(depositConsole.getDepositConsoleBalance()));
            preparedStatement.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
