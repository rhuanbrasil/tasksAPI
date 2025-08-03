package com.API.tasks.controller;

import com.API.tasks.business.TaskService;
import com.API.tasks.business.dtos.TaskRequestDTO;
import com.API.tasks.business.dtos.TaskResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Tasks", description = "Task controller with some CRUD functions")
@RequestMapping("/Task")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @PostMapping
    @Operation(summary = "task creation", description = "method to create a task")
    @ApiResponse(responseCode = "200", description = "New task was cadastred")
    public TaskResponseDTO createTask(@RequestBody TaskRequestDTO dto) {
        return service.createTask(dto);
    }
    @GetMapping
    @Operation(summary = "filter by task description", description = "method that filter task by its description")
    @ApiResponse(responseCode = "200", description = "the task was found")
    public TaskResponseDTO getTaskByDescription(@RequestParam String description) {
        return service.getTaskByDescription(description);
    }
    @PutMapping
    @Operation(
            summary = "set the task as complete",
            description = "method that set the task, that was filtered by id, complete"
    )
    @ApiResponse(responseCode = "200", description = "the task was marked as complete")
    public void setComplete(@RequestParam Long id) {
        service.setToComplete(id);
    }
    @PutMapping("/{id}")
    @Operation(
            summary = "updates the task",
            description = "updates the task"
    )
    @ApiResponse(responseCode = "200", description = "the task was updated")
    public void updateTask(@RequestBody TaskRequestDTO dto, @PathVariable("id") Long id) {
         service.updateTask(dto, id);
    }
    @GetMapping("/list")
    @Operation(
            summary = "lists the tasks",
            description = "lists the tasks"
    )
    @ApiResponse(responseCode = "200", description = "the task was updated")
    public List<TaskResponseDTO> listTasks() {
       return service.getTasks();
    }

}
