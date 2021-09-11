package com.hubert.todoapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TodoDto {

  private String description;

  private Boolean completed;

}
