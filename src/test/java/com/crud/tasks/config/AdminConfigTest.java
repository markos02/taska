package com.crud.tasks.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminConfigTest {

    @Autowired
    AdminConfig adminConfig;

    @Test
    void getAdminMail() {
        //Given
        //When
        //Then
        assertNotNull(adminConfig.getAdminMail());
    }
}