package com.ab.buscardsystem;

public class BusConsole {

    private Card card;
    private TappingCard tappingCard;
    private DBFacade dbFacade;

    public Card getCard() {
        return card;
    }
    public DBFacade getDbFacade() {
        return dbFacade;
    }
    public TappingCard getTappingCard() {
        return tappingCard;
    }

    public BusConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade; //BusConsole bizim oluşturduğumuz dbFacade'i bilmiyordu.Bilir hale geldi.
    }

    public void enterCardId(int cardId){

        tappingCard = new TappingCard();
        System.out.println("Busconsole tappingCard nesnesini oluşturdu: " + tappingCard);
        card = (Card) dbFacade.get(cardId, Card.class);
        System.out.println("Bus console card nesnesini çekti: " + card);
        tappingCard.set(card);
        dbFacade.put(tappingCard);
        System.out.println("işlem kaydedildi ama henüz CardId kontrolü yok");

    }

}
