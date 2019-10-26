package com.ab.buscardsystem;

import java.util.HashMap;
import java.util.Map;

public class Mapper {

    private HashMap<Class<?>, IMapper> mapper;
    private CardDBMapper cardDBMapper;
    private TappingCardDBMapper tappingCardDBMapper;

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

        HashMap<Class<?>, IMapper> mapper = new HashMap<>(); //Object tutmak yerine IMapper tipi de tutulabilir.
        this.mapper = mapper;

        CardDBMapper cardDBMapper = new CardDBMapper();
        this.cardDBMapper = cardDBMapper;
        TappingCardDBMapper tappingCardDBMapper = new TappingCardDBMapper();
        this.tappingCardDBMapper = tappingCardDBMapper;

        mapper.put(Card.class, cardDBMapper);
        mapper.put(TappingCard.class, tappingCardDBMapper);

    }

    public IMapper get(Class<?> parameterClass){
        return mapper.get(parameterClass);
    }
}