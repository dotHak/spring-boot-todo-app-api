package com.hubert.todoapp.controller;

import com.hubert.todoapp.dto.TodoDto;
import com.hubert.todoapp.entities.Todo;
import com.hubert.todoapp.service.TodoService;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {


  private final TodoService todoService;

  public TodoController(TodoService todoService) {
    this.todoService = todoService;
  }

  @GetMapping
  public List<Todo> findAll() {
    return todoService.findAll();
  }

  @GetMapping(value = "/{id}")
  public Optional<Todo> findById(@PathVariable("id") long id) {
    return todoService.findById(id);
  }

  @PostMapping
  public Todo newTodo(@RequestBody TodoDto todoDto) {
    assert todoDto != null;

    Todo todo = new Todo();
    todo.setDescription(todoDto.getDescription());
    todo.setCompleted(todoDto.getCompleted());

    return todoService.save(todo);
  }

  @PutMapping(value = "/{id}")
  public Todo updateTodo(@PathVariable("id") long id, @RequestBody TodoDto todoDto) {
    assert todoDto != null;

    return todoService.update(id, todoDto);
  }

  @DeleteMapping(value = "/{id}")
  public void deleteById(@PathVariable("id") long id) {
    todoService.deleteById(id);
  }
}
