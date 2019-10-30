package com.ab.buscardsystem;

public class DBFacade {

    private TableMapper tableMapper = new TableMapper();
    private IDataBase iDataBase;
    private BusConsole busConsole;
    private DepositCenterConsole depositCenterConsole;

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
    public BusConsole getBusConsole() {
        return busConsole;
    }

    public void setBusConsole(BusConsole busConsole) {
        this.busConsole = busConsole;
    }

    public DepositCenterConsole getDepositCenterConsole() {
        return depositCenterConsole;
    }

    public void setDepositCenterConsole(DepositCenterConsole depositCenterConsole) {
        this.depositCenterConsole = depositCenterConsole;
    }

}
