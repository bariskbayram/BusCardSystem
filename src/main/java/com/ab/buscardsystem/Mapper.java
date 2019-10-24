package com.ab.buscardsystem;

import java.util.HashMap;
import java.util.Map;

public class Mapper {


    public Mapper() {

        CardDBMapper cardDBMapper = new CardDBMapper();
        TappingCardDBMapper tappingCardDBMapper = new TappingCardDBMapper();

        HashMap<Class<?>, Object> mapper = new HashMap<>(); //Object tutmak yerine IMapper tipi de tutulabilir.
        mapper.put(Card.class, cardDBMapper);
        mapper.put(TappingCard.class, tappingCardDBMapper);

    }
}