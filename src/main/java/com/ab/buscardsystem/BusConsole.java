package com.ab.buscardsystem;

public class BusConsole {

    private Card card;
    private DBFacade dbFacade;


    private void enterCardId(int cardId){

        TappingCard tappingCard = new TappingCard();

        card = dbFacade.getCard(cardId, Card.class);
        tappingCard.set(card);
        dbFacade.put(tappingCard.getId(), tappingCard);

    }

}
