package com.ab.buscardsystem;

import java.util.HashMap;

public class TappingCardDBMapper implements IMapper {

    private HashMap<Integer, Object> tappingCardDBMapper;

    public HashMap<Integer, Object> getTappingCardDBMapper() {
        return tappingCardDBMapper;
    }

    public TappingCardDBMapper(){
        HashMap<Integer, Object> tappingCardDBMapper = new HashMap<>();
        this.tappingCardDBMapper = tappingCardDBMapper;
    }

    @Override
    public Object get(int id) {
        return tappingCardDBMapper.get(id);
    }

    @Override
    public void put(ParentObject object) {
        tappingCardDBMapper.put(object.getId(), object);
    }
}
