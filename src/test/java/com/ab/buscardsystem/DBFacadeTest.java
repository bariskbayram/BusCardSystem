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

        when(mapper.getMapper(Card.class)).thenReturn(cardDBMapper);
        when(cardDBMapper.getItem(anyInt())).thenReturn(card);

        assertEquals(card, dbFacade.get(anyInt(), Card.class));

        verify(mapper).getMapper(Card.class);
        verify(cardDBMapper).getItem(anyInt());

    }

    @Test
    @DisplayName("getTest with TappingCard")
    void getTappingCardTest() {

        when(mapper.getMapper(TappingCard.class)).thenReturn(tappingCardDBMapper);
        when(tappingCardDBMapper.getItem(anyInt())).thenReturn(tappingCard);

        assertEquals(tappingCard, dbFacade.get(anyInt(), TappingCard.class));
        assertEquals(tappingCard, dbFacade.get(anyInt(), TappingCard.class));
        assertEquals(tappingCard, dbFacade.get(anyInt(), TappingCard.class));
        verify(mapper, times(3)).getMapper(TappingCard.class);
        verify(tappingCardDBMapper, times(3)).getItem(anyInt());
    }
}