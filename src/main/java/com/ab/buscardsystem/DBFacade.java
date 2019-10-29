package com.ab.buscardsystem;

public class DBFacade {

    private TableMapper tableMapper = new TableMapper();
    private IDataBase DBMapper;

    public void setTableMapper(TableMapper tableMapper) {
        this.tableMapper = tableMapper;
    }
    public void setDBMapper(IDataBase DBMapper) {
        this.DBMapper = DBMapper;
    }

    public TableMapper getTableMapper() {
        return tableMapper;
    }
    public IDataBase getDBMapper() {
        return DBMapper;
    }

    public DBFacade(){
    }

    public Object get(int id, Class<?> parameterClass){
        DBMapper = tableMapper.getMapper(parameterClass);
        return DBMapper.getItem(id);
    }

    public void put(ParentObject object){
        IDataBase DBMapper = tableMapper.getMapper(object.getClass());
        DBMapper.putItem(object);
    }

}
