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

    public IMapper getDBMapper() {
        return DBMapper;
    }
    public Mapper getMapper() {
        return mapper;
    }


    public Object get(int id, Class<?> parameterClass){
        System.out.println("dbFacade get fonksiyonu çalıştı.");
        DBMapper = mapper.getMapper(parameterClass);
        System.out.println("Hangi mapperda tutulduğunu buldu.");
        return DBMapper.getItem(id);
    }

    public void put(ParentObject object){
        IMapper DBMapper = mapper.getMapper(object.getClass());
        DBMapper.putItem(object);
    }

}
