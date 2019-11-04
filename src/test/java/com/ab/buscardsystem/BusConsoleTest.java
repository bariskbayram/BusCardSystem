package com.ab.buscardsystem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.time.LocalTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BusConsoleTest {

    @InjectMocks
    BusConsole busConsole = new BusConsole();
    @Mock
    DBFacade dbFacade;
    @Mock
    TappingCard tappingCard;

    @Test
    @DisplayName("Verify enterCardId method's Call With Inactive Default Type")
    void enterCardIdNormalType() {

        //Given
        Card card = new Card(10);
        HashMap<Integer, LocalTime> invalidList = new HashMap<>();
        invalidList.put(5,busConsole.getLocalTime());
        busConsole.setInvalidList(invalidList);
        doNothing().when(tappingCard).setBusConsoleId(anyInt());
        when(dbFacade.get(card.getId(), Card.class)).thenReturn(card);
        tappingCard.setCurrentBalance(10);
        when(tappingCard.getBusConsoleId()).thenReturn(5);
        doNothing().when(tappingCard).set(card);
        doNothing().when(tappingCard).setCardId(10);
        doNothing().when(dbFacade).update(card);
        doNothing().when(dbFacade).put(tappingCard);
        when(tappingCard.getAmount()).thenReturn(3.25);
        when(tappingCard.getCurrentBalance()).thenReturn(10.0);

        //When
        busConsole.enterCardId(card.getId(), true, tappingCard);

        //Then
        assertTrue(busConsole.isTappingNormal());
        assertTrue(busConsole.isBalanceSitutation());
        assertTrue(invalidList.containsKey(10));
        verify(tappingCard).setAmount(3.25);
        verify(tappingCard).setBusConsoleId(anyInt());
        verify(dbFacade).get(card.getId(),Card.class);
        verify(tappingCard).set(card);
        verify(tappingCard).getBusConsoleId();
        verify(dbFacade).update(card);
        verify(dbFacade).put(tappingCard);

    }

    @Test
    @DisplayName("Verify enterCardId method's Call With Default Type Not Tapped")
    void enterCardIdDefaultTypeWitNotTapped() {

        //Given
        Card card = new Card(37);
        HashMap<Integer, LocalTime> invalidList = new HashMap<>();
        invalidList.put(5,busConsole.getLocalTime());
        busConsole.setInvalidList(invalidList);
        doNothing().when(tappingCard).setBusConsoleId(anyInt());
        when(dbFacade.get(card.getId(), Card.class)).thenReturn(card);
        tappingCard.setCurrentBalance(10.0);
        when(tappingCard.getBusConsoleId()).thenReturn(5);
        doNothing().when(tappingCard).set(card);
        doNothing().when(tappingCard).setCardId(37);
        doNothing().when(dbFacade).update(card);
        doNothing().when(dbFacade).put(tappingCard);
        when(tappingCard.getAmount()).thenReturn(3.25);
        when(tappingCard.getCurrentBalance()).thenReturn(10.0);

        //When
        busConsole.enterCardId(card.getId(), false, tappingCard);

        //Then
        assertTrue(busConsole.isCardTappingSitutation());
        assertFalse(busConsole.isTappingNormal());
        assertTrue(busConsole.isBalanceSitutation());
        assertTrue(invalidList.containsKey(37));
        verify(tappingCard).setBusConsoleId(anyInt());
        verify(dbFacade).get(card.getId(),Card.class);
        verify(tappingCard).set(card);
        verify(tappingCard).getBusConsoleId();
        verify(dbFacade).update(card);
        verify(dbFacade).put(tappingCard);

    }

    @Test
    @DisplayName("Verify enterCardId method's Call With Default Type Already Tapped")
    void enterCardIdDefaultTypeWithAlreadyTapped(){

        //Given
        Card card = new Card(42);
        HashMap<Integer, LocalTime> invalidList = new HashMap<>();
        invalidList.put(5,busConsole.getLocalTime());
        invalidList.put(42, busConsole.getLocalTime());
        busConsole.setInvalidList(invalidList);

        //When
        busConsole.enterCardId(card.getId(), false, tappingCard);

        //Then
        assertFalse(busConsole.isTappingNormal());
        assertFalse(busConsole.isCardTappingSitutation());

    }

    @Test
    @DisplayName("Card Is Not Tapped")
    void isCardAlreadyTappedNotTapped(){

        //Given
        HashMap<Integer, LocalTime> invalidList = new HashMap<>();
        LocalTime localTime = LocalTime.now();
        invalidList.put(10, localTime);
        busConsole.setInvalidList(invalidList);

        //When
        boolean situtation = busConsole.isCardAlreadyTapped(11);

        //Then
        assertTrue(situtation);

    }

    @Test
    @Disabled
    @DisplayName("Card Tapped But Not In 45 Minute")
    void isCardAlreadyTappedNotTappedIn(){

        //Given
        HashMap<Integer, LocalTime> invalidList = new HashMap<>();
        LocalTime localTime = LocalTime.now();
        invalidList.put(11, localTime.minusMinutes(47));
        busConsole.setInvalidList(invalidList);

        //When
        boolean situtation = busConsole.isCardAlreadyTapped(11);

        //Then
        assertTrue(situtation);

    }

    @Test
    @DisplayName("Is Card Already Tapped with 44 Minute")
    void isCardAlreadyTapped(){

        //Given
        HashMap<Integer, LocalTime> invalidList = new HashMap<>();
        LocalTime localTime = LocalTime.now();
        invalidList.put(11, localTime.minusMinutes(44));
        busConsole.setInvalidList(invalidList);

        //When
        boolean situtation = busConsole.isCardAlreadyTapped(11);

        //Then
        assertFalse(situtation);

    }

    @Test
    @DisplayName("Balance Is Not Enough with 3.24")
    void isCardBalanceEnoughFalse(){

        //Given
        TappingCard tappingCard = new TappingCard(1);
        tappingCard.setAmount(3.25);
        tappingCard.setCurrentBalance(3.24);

        //When

        //Then
        assertFalse(busConsole.isCardBalanceEnough(tappingCard));

    }

    @Test
    @DisplayName("Balance is enough with 3.26")
    void isCardBalanceEnoughTrue(){

        //Given
        TappingCard tappingCard = new TappingCard(1);
        tappingCard.setAmount(3.25);
        tappingCard.setCurrentBalance(3.26);

        //When-Then
        assertTrue(busConsole.isCardBalanceEnough(tappingCard));

    }
}