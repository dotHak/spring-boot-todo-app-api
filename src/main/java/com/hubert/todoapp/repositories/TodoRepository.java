package com.hubert.todoapp.repositories;

import com.hubert.todoapp.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
