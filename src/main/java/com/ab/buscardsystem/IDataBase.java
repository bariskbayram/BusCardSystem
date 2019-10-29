package com.ab.buscardsystem;

import java.sql.SQLException;

public interface IDataBase {

    Object getItem(int id);
    void putItem(ParentObject object);


}
