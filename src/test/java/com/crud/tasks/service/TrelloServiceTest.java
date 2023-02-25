package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.TrelloClient;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    TrelloClient trelloClient;

    @Mock
    AdminConfig adminConfig;

    @Mock
    SimpleEmailService simpleEmailService;

    @Test
    void fetchTrelloBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtos = List.of(new TrelloBoardDto());
        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtos);

        //When
        List<TrelloBoardDto> fetchedBoards = trelloService.fetchTrelloBoards();

        //Then
        assertNotNull(fetchedBoards);
        assertEquals(1, fetchedBoards.size());
    }

    @Test
    void createTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test card", "Creating card test", "10", "15");
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("15", "Test card", "url", new TrelloBadgesDto());
        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto createdCard = trelloService.createTrelloCard(trelloCardDto);

        //Then
        assertNotNull(createdCard);
        assertEquals("15", createdCard.getId());
        assertEquals("Test card", createdCard.getName());
        assertEquals("url", createdCard.getShortUrl());
        assertNotNull(createdCard.getBadges());
    }
}