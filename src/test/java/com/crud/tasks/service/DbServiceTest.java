package com.crud.tasks.service;

import com.crud.tasks.controller.TaskNotFoundException;
import com.crud.tasks.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DbServiceTest {

    @Autowired
    DbService dbService;

    @Test
    void shouldSaveTask() throws TaskNotFoundException {
        //Given
        Task task = new Task();
        task.setTitle("Test task");
        task.setContent("Testing DBService");

        //When
        dbService.saveTask(task);
        Long taskId = task.getId();
        Task retrievedTask = dbService.getTask(taskId);

        //Then
        assertNotNull(retrievedTask);
        assertEquals("Test task", retrievedTask.getTitle());

        //CleanUp
        dbService.deleteTask(taskId);
    }

    @Test
    void ShouldGetAllTasks() {
        //Given
        Task task1 = new Task();
        task1.setTitle("Test task");
        task1.setContent("Testing DBService");

        Task task2 = new Task();
        task2.setTitle("Test task");
        task2.setContent("Testing DBService");

        //When
        dbService.saveTask(task1);
        dbService.saveTask(task2);
        Long task1Id = task1.getId();
        Long task2Id = task2.getId();
        List<Task> retrievedTasks = dbService.getAllTasks();

        //Then
        assertNotNull(retrievedTasks);
        assertEquals(2, retrievedTasks.size());

        //CleanUp
        dbService.deleteTask(task1Id);
        dbService.deleteTask(task2Id);
    }

    @Test
    void getTaskShouldThrowException() throws TaskNotFoundException {
        //Given
        //When
        //Then
        assertThrows(TaskNotFoundException.class, () -> dbService.getTask(1L));
    }
}