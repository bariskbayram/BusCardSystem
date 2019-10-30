package com.ab.buscardsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepositCenterConsoleDB implements IDataBase {

    private SqliteDB sqliteDB;
    private DepositCenterConsole depositCenterConsole;

    public DepositCenterConsoleDB(SqliteDB sqliteDB){
        this.sqliteDB = sqliteDB;
    }

    @Override
    public Object getItem(int id) {

        try {
            sqliteDB.connectDB();
            String query = "SELECT * FROM DepositCenterConsole WHERE Id = ?";
            PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
            preparedStatement.setString(1,String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                DepositCenterConsole depositCenterConsole = new DepositCenterConsole();
                depositCenterConsole.setDepositCenterConsoleId(resultSet.getInt("Id"));
                depositCenterConsole.setDepositCenterConsoleBalance(resultSet.getDouble("Balance"));
                this.depositCenterConsole = depositCenterConsole;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return depositCenterConsole;
    }

    @Override
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            DepositCenterConsole depositConsole = (DepositCenterConsole) object;
            String queryDelete = "DELETE FROM DepositCenterConsole WHERE Id = ?"; //Eğer olmayan kart ekleme senaryosu çalışırsa delete sorun çıkarabilir.
            PreparedStatement preparedStatementDelete = sqliteDB.connection.prepareStatement(queryDelete);
            preparedStatementDelete.setString(1,String.valueOf(depositConsole.getDepositCenterConsoleId()));
            preparedStatementDelete.executeUpdate();
            String query = "INSERT INTO DepositCenterConsole (Id, Balance) VALUES (?,?)";
            PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(depositConsole.getDepositCenterConsoleId()));
            preparedStatement.setString(2, String.valueOf(depositConsole.getDepositCenterConsoleBalance()));
            preparedStatement.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
