package com.ab.buscardsystem;

public class DBFacade {

    private Mapper mapper = new Mapper();
    private IMapper DBMapper;

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }
    public void setDBMapper(IMapper DBMapper) {
        this.DBMapper = DBMapper;
    }

    public Mapper getMapper() {
        return mapper;
    }
    public IMapper getDBMapper() {
        return DBMapper;
    }

    public DBFacade(){
    }

    public Object get(int id, Class<?> parameterClass){
        DBMapper = mapper.getMapper(parameterClass);
        return DBMapper.getItem(id);
    }

    public void put(ParentObject object){
        IMapper DBMapper = mapper.getMapper(object.getClass());
        DBMapper.putItem(object);
    }

}
