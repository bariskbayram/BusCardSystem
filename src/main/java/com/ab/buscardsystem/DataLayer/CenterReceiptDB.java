package com.ab.buscardsystem.DataLayer;

import com.ab.buscardsystem.BusinessLayer.CenterReceipt;
import com.ab.buscardsystem.ParentObject;

import java.sql.PreparedStatement;

public class CenterReceiptDB implements IDataBase {

    private SqliteDB sqliteDB;

    public CenterReceiptDB(SqliteDB sqliteDB){
        this.sqliteDB = sqliteDB;
    }
    @Override
    public Object getItem(int id) {
        return null;
    }

    @Override
    public void deleteItem(int id) {}

    @Override
    public void updateItem(ParentObject object) {}

    @Override
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            String query = "INSERT INTO CenterReceipt (CenterConsoleId, Date, Time, Payment, Change, Amount) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            CenterReceipt centerReceipt = (CenterReceipt) object;
            preparedStatement.setString(1, String.valueOf(centerReceipt.getCenterConsoleId()));
            preparedStatement.setString(2, String.valueOf(centerReceipt.getLocalDate()));
            preparedStatement.setString(3, String.valueOf(centerReceipt.getLocalTime()));
            preparedStatement.setString(4, String.valueOf(centerReceipt.getPayment()));
            preparedStatement.setString(5, String.valueOf(centerReceipt.getChange()));
            preparedStatement.setString(6, String.valueOf(centerReceipt.getAmount()));
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

}
