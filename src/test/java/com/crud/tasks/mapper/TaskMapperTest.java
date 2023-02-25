package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TaskMapperTest {

    @InjectMocks
    private TaskMapper taskMapper;

    @Test
    void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "Test task", "Testing task mapper");

        //When
        Task mappedTask = taskMapper.mapToTask(taskDto);

        //Then
        assertNotNull(mappedTask);
        assertEquals("Test task", mappedTask.getTitle());
    }

    @Test
    void mapToTaskDto() {
        //Given
        Task task = new Task(1L, "Test task", "Testing task mapper");

        //When
        TaskDto mappedTask = taskMapper.mapToTaskDto(task);

        //Then
        assertNotNull(mappedTask);
        assertEquals("Test task", mappedTask.getTitle());
    }

    @Test
    void mapToTaskDtoList() {
        //Given
        Task task1 = new Task(1L, "Test task 1", "Testing task 1 mapper");
        Task task2 = new Task(1L, "Test task 2", "Testing task 2 mapper");
        List<Task> taskList = List.of(task1,task2);

        //When
        List<TaskDto> mappedTaskList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        assertNotNull(mappedTaskList);
        assertEquals(2, mappedTaskList.size());
    }
}