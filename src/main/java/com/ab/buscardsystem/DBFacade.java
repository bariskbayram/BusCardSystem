package com.ab.buscardsystem;

public class DBFacade {

    private TableMapper tableMapper = new TableMapper();
    private IDataBase iDataBase;

    public DBFacade(){
    }

    public Object get(int id, Class<?> parameterClass){
        iDataBase = tableMapper.getMapper(parameterClass);
        return iDataBase.getItem(id);
    }

    public void put(ParentObject object){
        IDataBase DBMapper = tableMapper.getMapper(object.getClass());
        DBMapper.putItem(object);
    }

    public void setTableMapper(TableMapper tableMapper) {
        this.tableMapper = tableMapper;
    }
    public void setiDataBase(IDataBase iDataBase) {
        this.iDataBase = iDataBase;
    }
    public TableMapper getTableMapper() {
        return tableMapper;
    }
    public IDataBase getiDataBase() {
        return iDataBase;
    }

}
