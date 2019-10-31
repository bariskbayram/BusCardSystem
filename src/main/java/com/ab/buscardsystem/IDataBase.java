package com.ab.buscardsystem;

public interface IDataBase {

    Object getItem(int id);
    void deleteItem(int id);
    void updateItem(ParentObject object);
    void putItem(ParentObject object);


}
