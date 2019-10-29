package com.ab.buscardsystem;

import java.util.HashMap;
import java.util.Map;

public class Mapper {

    private HashMap<Class<?>, IMapper> mapper = new HashMap<>();
    private CardDBMapper cardDBMapper = new CardDBMapper();
    private TappingCardDBMapper tappingCardDBMapper = new TappingCardDBMapper();

    public void setMapper(HashMap<Class<?>, IMapper> mapper) {
        this.mapper = mapper;
    }
    public void setCardDBMapper(CardDBMapper cardDBMapper) {
        this.cardDBMapper = cardDBMapper;
    }
    public void setTappingCardDBMapper(TappingCardDBMapper tappingCardDBMapper) {
        this.tappingCardDBMapper = tappingCardDBMapper;
    }

    public CardDBMapper getCardDBMapper() {
        return cardDBMapper;
    }
    public TappingCardDBMapper getTappingCardDBMapper() {
        return tappingCardDBMapper;
    }
    public HashMap<Class<?>, IMapper> getMapper() {
        return mapper;
    }

    public Mapper() {

        mapper.put(Card.class, cardDBMapper);
        mapper.put(TappingCard.class, tappingCardDBMapper);

    }

    public IMapper getMapper(Class<?> parameterClass){
        return mapper.get(parameterClass);
    }
}