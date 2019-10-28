package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DBFacadeTest {

    @Mock
    private IMapper cardDBMapper;
    @Mock
    private Mapper mapper;
    @Mock
    private Card card;
    @Mock
    private TappingCard tappingCard;
    @Mock
    private TappingCardDBMapper tappingCardDBMapper;

    @InjectMocks
    private DBFacade dbFacade;

    @Test
    @DisplayName("getTest with Card")
    public void getCardTest() {

        when(mapper.get(Card.class)).thenReturn(cardDBMapper);
        when(cardDBMapper.get(anyInt())).thenReturn(card);

        verify(mapper).get(Card.class);
        verify(cardDBMapper).get(anyInt());
        
        assertEquals(card, dbFacade.get(anyInt(), Card.class));

    }

    @Test
    @DisplayName("getTest with TappingCard")
    void getTappingCardTest() {

        when(mapper.get(TappingCard.class)).thenReturn(tappingCardDBMapper);
        when(tappingCardDBMapper.get(anyInt())).thenReturn(tappingCard);

        assertEquals(tappingCard, dbFacade.get(anyInt(), TappingCard.class));
        assertEquals(tappingCard, dbFacade.get(anyInt(), TappingCard.class));
        assertEquals(tappingCard, dbFacade.get(anyInt(), TappingCard.class));
        verify(mapper, times(3)).get(TappingCard.class);
        verify(tappingCardDBMapper, times(3)).get(anyInt());
    }
}