package com.ab.buscardsystem;

public class BusConsole {

    private Card card;
    private TappingCard tappingCard;
    private DBFacade dbFacade;

    public void setCard(Card card) {
        this.card = card;
    }
    public void setTappingCard(TappingCard tappingCard) {
        this.tappingCard = tappingCard;
    }
    public void setDbFacade(DBFacade dbFacade) {
        this.dbFacade = dbFacade;
    }

    public Card getCard() {
        return card;
    }
    public TappingCard getTappingCard() {
        return tappingCard;
    }
    public DBFacade getDbFacade() {
        return dbFacade;
    }

    public BusConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade; //BusConsole bizim oluşturduğumuz dbFacade'i bilmiyordu.Bilir hale geldi.
    }

    public void enterCardId(int cardId){

        tappingCard = new TappingCard(3);
        card = (Card) dbFacade.get(cardId, Card.class);
        tappingCard.set(card);
        dbFacade.put(tappingCard);

    }

}
