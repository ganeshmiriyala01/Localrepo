package com.app.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ModelTodo {
    String userId;
    Integer id;
    String title;
    String completed;
}
