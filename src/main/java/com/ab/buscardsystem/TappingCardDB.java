package com.ab.buscardsystem;

import java.util.HashMap;

public class TappingCardDB implements IDataBase {

    private HashMap<Integer, Object> tappingCardDBMapper = new HashMap<>();

    public void setTappingCardDBMapper(HashMap<Integer, Object> tappingCardDBMapper) {
        this.tappingCardDBMapper = tappingCardDBMapper;
    }

    public HashMap<Integer, Object> getTappingCardDBMapper() {
        return tappingCardDBMapper;
    }

    public TappingCardDB(){
    }

    @Override
    public Object getItem(int id) {
        return tappingCardDBMapper.get(id);
    }

    @Override
    public void putItem(ParentObject object) {
        tappingCardDBMapper.put(object.getId(), object);
    }
}
