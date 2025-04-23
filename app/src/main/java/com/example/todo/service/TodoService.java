package com.example.todo.service;

import com.example.todo.domain.Todo;
import com.example.todo.repository.TodoRepository;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService {
    private final MeterRegistry meterRegistry;
    private final TodoRepository todoRepository;

    public List<Todo> findAll(String user) {
        return todoRepository.findByUsername(user);
    }
    public Todo save(Todo todo) {
        meterRegistry.counter("todo.created").increment();
        return todoRepository.save(todo);
    }
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}

