package com.pironix.service;

import com.pironix.model.Todo;
import com.pironix.model.Users;
import com.pironix.utils.Status;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by ibrahim
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * @since 9/3/2016.
 */
public interface TodoService {
    Todo saveTodo(Todo todo);

    Boolean deleteTodo(int id);

    Todo editTodo(Todo todo);

    Todo findTodo(int id);

    List<Todo> getAll();

    List<Todo> findByStatus(String status);

    List<Todo> findByUserIdStatus(int userId, String status);

}
