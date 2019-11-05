package com.ab.buscardsystem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sqlite.core.DB;

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
    @Mock
    FactoryInput factoryInput;

    @Test
    @DisplayName("Verify enterCardId method's Call With Inactive Default Type")
    void enterCardIdNormalType() {

        //Given
        Card card = new Card(10);
        HashMap<Integer, LocalTime> invalidList = new HashMap<>();
        busConsole.setInvalidList(invalidList);
        when(dbFacade.get(card.getId(), Card.class)).thenReturn(card);
        doNothing().when(tappingCard).set(card);
        doNothing().when(dbFacade).update(card);
        doNothing().when(dbFacade).put(tappingCard);

        //When
        busConsole.enterCardId(card.getId(), true, tappingCard);

        //Then
        assertEquals(busConsole.getTappingCard(), tappingCard);
        assertTrue(busConsole.isTappingNormal());
        assertTrue(invalidList.containsKey(10));
        verify(tappingCard).set(card);
        verify(tappingCard).setCardId(card.getId());
        verify(tappingCard).setBusConsoleId(anyInt());
        verify(dbFacade).get(card.getId(),Card.class);
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
        busConsole.setInvalidList(invalidList);
        when(dbFacade.get(card.getId(), Card.class)).thenReturn(card);
        when(tappingCard.getBusConsoleId()).thenReturn(5);
        doNothing().when(tappingCard).set(card);
        doNothing().when(dbFacade).update(card);
        doNothing().when(dbFacade).put(tappingCard);

        //When
        busConsole.enterCardId(card.getId(), false, tappingCard);

        //Then
        assertEquals(busConsole.getTappingCard(), tappingCard);
        assertTrue(busConsole.isCardTappingSitutation());
        assertFalse(busConsole.isTappingNormal());
        assertTrue(invalidList.containsKey(37));
        verify(tappingCard).set(card);
        verify(tappingCard).setCardId(card.getId());
        verify(tappingCard).setBusConsoleId(anyInt());
        verify(dbFacade).get(card.getId(),Card.class);
        verify(tappingCard).getBusConsoleId();
        verify(dbFacade).update(card);
        verify(dbFacade).put(tappingCard);

    }

    @Test
    @DisplayName("Verify enterCardId method's Call With Default Type Already Tapped")
    void enterCardIdDefaultTypeWithAlreadyTapped(){

        Card card = new Card(41);
        HashMap<Integer, LocalTime> invalidList = new HashMap<>();
        invalidList.put(41, LocalTime.now().minusMinutes(34));
        busConsole.setInvalidList(invalidList);

        //When
        busConsole.enterCardId(card.getId(), false, tappingCard);

        //Then
        assertEquals(busConsole.getTappingCard(), tappingCard);
        assertFalse(busConsole.isCardTappingSitutation());
        assertFalse(busConsole.isTappingNormal());
        assertTrue(invalidList.containsKey(41));
        assertTrue(busConsole.getTime() < 45);
    }

    @Test
    @DisplayName("Verify enterCardId method's Call With Default Type Tapped But Not in 45 Minutes")
    void enterCardIdDefaultTypeWithTappedButNotIn45Minutes(){

        Card card = new Card(41);
        HashMap<Integer, LocalTime> invalidList = new HashMap<>();
        invalidList.put(41, LocalTime.now().minusMinutes(46));
        busConsole.setInvalidList(invalidList);
        when(dbFacade.get(card.getId(), Card.class)).thenReturn(card);
        when(tappingCard.getBusConsoleId()).thenReturn(5);
        doNothing().when(tappingCard).set(card);
        doNothing().when(dbFacade).update(card);
        doNothing().when(dbFacade).put(tappingCard);

        //When
        busConsole.enterCardId(card.getId(), false, tappingCard);

        //Then
        assertEquals(busConsole.getTappingCard(), tappingCard);
        assertTrue(busConsole.isCardTappingSitutation());
        assertFalse(busConsole.isTappingNormal());
        assertTrue(invalidList.containsKey(41));
        assertTrue(busConsole.getTime() >= 45);
        verify(tappingCard).set(card);
        verify(tappingCard).setCardId(card.getId());
        verify(tappingCard).setBusConsoleId(anyInt());
        verify(dbFacade).get(card.getId(),Card.class);
        verify(tappingCard).getBusConsoleId();
        verify(dbFacade).update(card);
        verify(dbFacade).put(tappingCard);
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
        assertTrue(busConsole.getTime() >= 45);

    }

    @Test
    @DisplayName("Card Tapped In 45 Minute")
    void isCardAlreadyTappedIn45Minute(){

        //Given
        HashMap<Integer, LocalTime> invalidList = new HashMap<>();
        LocalTime localTime = LocalTime.now();
        invalidList.put(11, localTime.minusMinutes(35));
        busConsole.setInvalidList(invalidList);

        //When
        boolean situtation = busConsole.isCardAlreadyTapped(11);

        //Then
        assertFalse(situtation);
        assertTrue(busConsole.getTime() < 45);

    }

    @Test
    @DisplayName("Verify enterCardId Parameter with Null Throw Exception")
    void verifyEntertCardIdParameterWithNullThrowException(){
        //Given
        String expectedMessage = "TappingCard is null";
        String actualMessage = null;

        //When
        try {
            busConsole.enterCardId(32, false, null);
        }catch (Exception e){
            actualMessage = e.getMessage();
        }

        //Then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Verify enterCardId Card with Null Throw Exception")
    void verifyEnterCardIdCardWithNullThrowException(){
        //Given
        String expectedMessage = "Card is null";
        String actualMessage = null;
        when(dbFacade.get(22, Card.class)).thenReturn(null);

        //When
        try {
            busConsole.enterCardId(22,true,new TappingCard(1));
        }catch (Exception e){
            actualMessage = e.getMessage();
        }

        //Then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Verify enterDriverId With Success Senario")
    void enterDriverIdVerifySuccessSenario(){
        //Given
        Driver driver = new Driver(14);
        DriverLogIn driverLogIn = new DriverLogIn();
        when(factoryInput.inputIntegerId()).thenReturn(32).thenReturn(14);
        when(dbFacade.get(driver.getId(), Driver.class)).thenReturn(driver);
        doNothing().when(dbFacade).put(driverLogIn);
        when(dbFacade.get(32, BusConsole.class)).thenReturn(busConsole);

        //When
        busConsole.enterDriverId(driverLogIn);

        //Then
        assertEquals(1, busConsole.getIsCorrect());
        assertTrue(busConsole.isBusConsoleExist);
        assertEquals(32,driverLogIn.getBusConsoleId());
        assertEquals(32, busConsole.getId());
        assertEquals(14, driverLogIn.getDriverId());
        assertEquals(busConsole.getDriverLogIn(), driverLogIn);
        verify(factoryInput, times(2)).inputIntegerId();
        verify(dbFacade).get(driver.getId(), Driver.class);
        verify(dbFacade).put(driverLogIn);
    }

    @Test
    @DisplayName("Verify enterDriverId With Wrong BusConsoleId 3 Times")
    void verifyEnterDriverIdWithWrongBusConsoleId3Times(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(-3).thenReturn(-52).thenReturn(0);

        //When
        busConsole.enterDriverId(new DriverLogIn());

        //Then
        assertEquals(0, busConsole.getIsCorrect());
        verify(factoryInput, times(3)).inputIntegerId();
    }

    @Test
    @DisplayName("Verify enterDriverId With Wrong DriverId 3 Times")
    void verifyEnterDriverIdWithWrongDriverId3Times(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(-1).thenReturn(23242423).thenReturn(0);

        //When
        busConsole.enterDriverId(new DriverLogIn());
        //Then
        assertEquals(0, busConsole.getIsCorrect());
        verify(factoryInput, times(3)).inputIntegerId();

    }

    @Test
    @DisplayName("Verify enterDriverId Parameter with Null Throw Exception")
    void verifyEnterDriverIdParameterWithNullThrowException(){
        //Given
        String expectedMessage = "DriverLogIn is null";
        String actualMessage = null;

        //When
        try {
            busConsole.enterDriverId(null);
        }catch (Exception e){
            actualMessage = e.getMessage();
        }

        //Then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Verify enterCardId Card with Null Throw Exception")
    void verifyEnterCardInfoParameterWithNullThrowException2(){
        //Given
        String expectedMessage = "Driver is null";
        String actualMessage = null;
        when(dbFacade.get(424, Driver.class)).thenReturn(null);
        when(factoryInput.inputIntegerId()).thenReturn(32).thenReturn(424);
        when(dbFacade.get(32, BusConsole.class)).thenReturn(busConsole);

        //When
        try {
            busConsole.enterDriverId(new DriverLogIn());
        }catch (Exception e){
            actualMessage = e.getMessage();
        }

        //Then
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Verify getAndEquals Method with Null BusConsole")
    void verifyGetAndEqualsMethodWithNullBusConsole(){

        //Given
        DriverLogIn driverLogIn = new DriverLogIn();
        when(factoryInput.inputIntegerId()).thenReturn(32);
        when(dbFacade.get(32, BusConsole.class)).thenReturn(null);

        //When
        busConsole.enterDriverId(driverLogIn);
        // Then
        assertFalse(busConsole.isBusConsoleExist);

    }




}