package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToBoards() {
        //Given
        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("Test board 1", "1", new ArrayList<>());
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("Test board 2", "2", new ArrayList<>());
        TrelloBoardDto trelloBoardDto3 = new TrelloBoardDto("Test board 3", "3", new ArrayList<>());

        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto1);
        trelloBoardDtoList.add(trelloBoardDto2);
        trelloBoardDtoList.add(trelloBoardDto3);

        //When
        List<TrelloBoard> mappedList = trelloMapper.mapToBoards(trelloBoardDtoList);

        //Then
        assertEquals(3, mappedList.size());
        assertEquals("Test board 1", mappedList.get(0).getName());
    }

    @Test
    void testMapToBoardsDto() {
        //Given
        TrelloBoard trelloBoard1 = new TrelloBoard("Test board 1", "1", new ArrayList<>());
        TrelloBoard trelloBoard2 = new TrelloBoard("Test board 2", "2", new ArrayList<>());
        TrelloBoard trelloBoard3 = new TrelloBoard("Test board 3", "3", new ArrayList<>());

        List<TrelloBoard> trelloBoardList = new ArrayList<>();
        trelloBoardList.add(trelloBoard1);
        trelloBoardList.add(trelloBoard2);
        trelloBoardList.add(trelloBoard3);

        //When
        List<TrelloBoardDto> mappedList = trelloMapper.mapToBoardsDto(trelloBoardList);

        //Then
        assertEquals(3, mappedList.size());
        assertEquals("Test board 1", mappedList.get(0).getName());
    }

    @Test
    void testMapToList() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "Test list 1", false);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "Test list 2", false);
        TrelloListDto trelloListDto3 = new TrelloListDto("3", "Test list 3", false);

        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(trelloListDto1);
        trelloListDtoList.add(trelloListDto2);
        trelloListDtoList.add(trelloListDto3);

        //When
        List<TrelloList> mappedList = trelloMapper.mapToList(trelloListDtoList);

        //Then
        assertEquals(3, mappedList.size());
        assertEquals("Test list 1", mappedList.get(0).getName());
    }

    @Test
    void testMapToListDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "Test list 1", false);
        TrelloList trelloList2 = new TrelloList("2", "Test list 2", false);
        TrelloList trelloList3 = new TrelloList("3", "Test list 3", false);

        List<TrelloList> trelloListList = new ArrayList<>();
        trelloListList.add(trelloList1);
        trelloListList.add(trelloList2);
        trelloListList.add(trelloList3);

        //When
        List<TrelloListDto> mappedList = trelloMapper.mapToListDto(trelloListList);

        //Then
        assertEquals(3, mappedList.size());
        assertEquals("Test list 1", mappedList.get(0).getName());
    }

    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("Test card 1", "Description of test card 1", "1", "1");

        //When
        TrelloCardDto mappedCart = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertNotNull(mappedCart);
        assertEquals("Test card 1", mappedCart.getName());
        assertEquals("Description of test card 1", mappedCart.getDescription());
        assertEquals("1", mappedCart.getPos());
        assertEquals("1", mappedCart.getListId());
    }

    @Test
    void testMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("Test card 1", "Description of test card 1", "1", "1");

        //When
        TrelloCard mappedCart = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertNotNull(mappedCart);
        assertEquals("Test card 1", mappedCart.getName());
        assertEquals("Description of test card 1", mappedCart.getDescription());
        assertEquals("1", mappedCart.getPos());
        assertEquals("1", mappedCart.getListId());
    }
}