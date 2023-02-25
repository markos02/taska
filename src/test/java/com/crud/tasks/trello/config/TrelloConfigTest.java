package com.crud.tasks.trello.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloConfigTest {

    @Autowired
    TrelloConfig trelloConfig;

    @Test
    void testGetValues() {
        //Given
        //When
        //Then
        assertNotNull(trelloConfig.getTrelloToken());
        assertNotNull(trelloConfig.getTrelloUsername());
        assertNotNull(trelloConfig.getTrelloApiEndpoint());
        assertNotNull(trelloConfig.getTrelloAppKey());
    }
}