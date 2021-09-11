package com.hubert.todoapp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "todos")
@Getter
@Setter
@NoArgsConstructor
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private String description;
  private boolean completed;
}
