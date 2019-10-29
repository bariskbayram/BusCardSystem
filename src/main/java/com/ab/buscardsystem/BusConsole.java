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

        card = (Card) dbFacade.get(cardId, Card.class);  //spesifik obje

        tappingCard.set(card);  //tapping cardın set fonksiyonu bu spesifik card objesi ile calıstırıldı
                                //tapping card nesnesinden hesaplamalar yapıldı ve tappingCard degistirildi
        dbFacade.put(tappingCard); //bu tapping card nesnesi dbfacace yardımı ile gerekli yere konuldu

        System.out.println("işlem kaydedildi ama henüz CardId kontrolü yok");

    }

}
