package com.ab.buscardsystem;

import java.util.HashMap;

public class CardDBMapper implements IMapper {

    private HashMap<Integer, Object> cardDBMapper;

    public HashMap<Integer, Object> getCardDBMapper() {
        return cardDBMapper;
    }

    public CardDBMapper() {
        HashMap<Integer, Object> cardDBMapper = new HashMap<>();
        this.cardDBMapper = cardDBMapper;
        Card card = new Card();
        cardDBMapper.put(card.getId(), card);
    }


    @Override
    public Object get(int id) {
        System.out.println("Card nesnesine ulaşıldı.");
        return cardDBMapper.get(id);
    }

    @Override
    public void put(ParentObject object) {
        cardDBMapper.put(object.getId(), object);
    }
}
