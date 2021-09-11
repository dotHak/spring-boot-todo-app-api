package com.hubert.todoapp.service;

import com.hubert.todoapp.dto.TodoDto;
import com.hubert.todoapp.entities.Todo;
import com.hubert.todoapp.repositories.TodoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

  private final TodoRepository todoRepository;

  @Autowired
  public TodoService(TodoRepository todoRepository) {
    this.todoRepository = todoRepository;
  }

  public static Object orElse(Object newValue, Object defaultValue) {
    return Optional.ofNullable(newValue).orElse(defaultValue);
  }

  public List<Todo> findAll() {
    return todoRepository.findAll();
  }

  public Optional<Todo> findById(long id) {
    return todoRepository.findById(id);
  }

  public Todo save(Todo todo) {
    return todoRepository.save(todo);
  }

  public Todo update(long id, TodoDto todoDto) {
    return todoRepository.findById(id).map(todo -> {
      todo.setCompleted((Boolean) orElse(todoDto.getCompleted(), todo.isCompleted()));
      todo.setDescription((String) orElse(todoDto.getDescription(), todo.getDescription()));
      return todoRepository.save(todo);
    }).orElseThrow(() -> new IllegalArgumentException("Todo not found"));
  }

  public void deleteById(long id) {
    todoRepository.deleteById(id);
  }
}
