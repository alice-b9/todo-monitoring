package com.example.todo.controller;

import com.example.todo.domain.Todo;
import com.example.todo.service.TodoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name="Todo", description = "Todo 관리")
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoService todoService;

    @GetMapping("/{user}")
    public List<Todo> list(@PathVariable String user) {
        return todoService.findAll(user);
    }
    @PostMapping
    public Todo add(@RequestBody Todo todo) {
        return todoService.save(todo);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }
}
