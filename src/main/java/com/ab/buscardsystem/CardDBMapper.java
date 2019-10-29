package com.ab.buscardsystem;

import java.util.HashMap;

public class CardDBMapper implements IMapper {

    private HashMap<Integer, Object> cardDBMapper = new HashMap<>();

    public void setCardDBMapper(HashMap<Integer, Object> cardDBMapper) {
        this.cardDBMapper = cardDBMapper;
    }

    public HashMap<Integer, Object> getCardDBMapper() {
        return cardDBMapper;
    }

    public CardDBMapper() {

        Card card = new Card(31);
        cardDBMapper.put(card.getId(), card);
    }


    @Override
    public Object getItem(int id) {
        System.out.println("Card nesnesine ulaşıldı.");
        return cardDBMapper.get(id);
    }

    @Override
    public void putItem(ParentObject object) {
        cardDBMapper.put(object.getId(), object);
    }
}
