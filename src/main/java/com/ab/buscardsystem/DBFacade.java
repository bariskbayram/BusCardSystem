package com.ab.buscardsystem;

public class DBFacade {

    private Mapper mapper;
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

    public DBFacade(){
        Mapper mapper = new Mapper();
        this.mapper = mapper;
        System.out.println("DBFacade Mapper nesnesini oluşturdu : " + mapper);
    }

    public Object get(int id, Class<?> parameterClass){
        System.out.println("dbFacade get fonksiyonu çalıştı.");
        DBMapper = mapper.get(parameterClass);
        System.out.println("Hangi mapperda tutulduğunu buldu.");
        return DBMapper.get(id);
    }

    public void put(ParentObject object){
        IMapper DBMapper = mapper.get(object.getClass());
        DBMapper.put(object);
    }

}
