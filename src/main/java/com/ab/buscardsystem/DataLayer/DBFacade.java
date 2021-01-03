package com.ab.buscardsystem.DataLayer;

import com.ab.buscardsystem.ParentObject;

public class DBFacade {

    private TableMapper tableMapper = new TableMapper();
    private IDataBase iDataBase;

    public Object get(int id, Class<?> parameterClass){
        iDataBase = tableMapper.getMapper(parameterClass);
        return iDataBase.getItem(id);
    }

    public void delete(int id, Class<?> parameterClass){
        iDataBase = tableMapper.getMapper(parameterClass);
        iDataBase.deleteItem(id);
    }

    public void update(ParentObject object){
        IDataBase DBMapper = tableMapper.getMapper(object.getClass());
        DBMapper.updateItem(object);
    }

    public void put(ParentObject object){
        IDataBase DBMapper = tableMapper.getMapper(object.getClass());
        DBMapper.putItem(object);
    }
}
