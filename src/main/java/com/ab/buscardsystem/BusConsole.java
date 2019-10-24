package com.ab.buscardsystem;

public class BusConsole {

    private Card card;
    private DBFacade dbFacade;
    TappingCard tappingCard;

    private void enterCardId(int cardId){

        tappingCard = new TappingCard();

        card = dbFacade.get(cardId, Card);
        tappingCard.set(card);
        dbFacade.put(tappingCard.getId(), tappingCard);

    }

}
