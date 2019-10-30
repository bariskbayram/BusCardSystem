package com.ab.buscardsystem;

public class DepositToDepositCenterReceiptDB implements IDataBase {

    private SqliteDB sqliteDB;

    public DepositToDepositCenterReceiptDB(SqliteDB sqliteDB){
        this.sqliteDB = sqliteDB;
    }

    @Override
    public Object getItem(int id) {
        return null;
    }

    @Override
    public void putItem(ParentObject object) {

    }

    public SqliteDB getSqliteDB() {
        return sqliteDB;
    }
    public void setSqliteDB(SqliteDB sqliteDB) {
        this.sqliteDB = sqliteDB;
    }
}
