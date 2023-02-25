package com.crud.tasks.trello.validator;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.trello.facade.TrelloFacade;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloValidatorTest {

    @Autowired
    TrelloValidator trelloValidator;

    @Test
    void validateTestCard() {
        //Given
        Logger logger = (Logger) LoggerFactory.getLogger(TrelloValidator.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        TrelloCard trelloCard = new TrelloCard("test card", "description", "1", "2");

        //When
        trelloValidator.validateCard(trelloCard);

        //Then
        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals("Someone is testing my application!", logsList.get(0).getMessage());
    }

    @Test
    void validateProperCard() {
        //Given
        Logger logger = (Logger) LoggerFactory.getLogger(TrelloValidator.class);
        ListAppender<ILoggingEvent> listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);

        TrelloCard trelloCard = new TrelloCard("Proper card", "description", "1", "2");

        //When
        trelloValidator.validateCard(trelloCard);

        //Then
        List<ILoggingEvent> logsList = listAppender.list;
        assertEquals("Seems that my application is used in proper way.", logsList.get(0).getMessage());
    }

    @Test
    void validateTrelloBoards() {
        //Given
        TrelloBoard trelloBoard1 = new TrelloBoard("1", "test", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("2", "Not test", new ArrayList<>());

        List<TrelloBoard> boardList = List.of(trelloBoard1, trelloBoard2);

        //When
        List<TrelloBoard> validatedBoardList = trelloValidator.validateTrelloBoards(boardList);

        //Then
        assertEquals(1, validatedBoardList.size());
        assertEquals("Not test", validatedBoardList.get(0).getName());
    }
}