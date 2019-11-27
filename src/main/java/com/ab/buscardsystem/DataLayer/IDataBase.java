package com.ab.buscardsystem.DataLayer;

import com.ab.buscardsystem.ParentObject;

public interface IDataBase {

    Object getItem(int id);
    void deleteItem(int id);
    void updateItem(ParentObject object);
    void putItem(ParentObject object);


}
