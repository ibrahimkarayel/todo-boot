package com.pironix.service;

import com.pironix.model.Todo;
import com.pironix.model.Users;
import com.pironix.utils.Status;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * The TodoService interface
 * <p>
 * Created by ibrahim
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * @since 9/3/2016.
 */
public interface TodoService {
    /**
     * @param todo saved Todo object
     * @return saved Todo object
     */
    Todo saveTodo(Todo todo);

    /**
     * @param id todo_id
     * @return <tt>true</tt> if Todo object  deleted
     */
    Boolean deleteTodo(int id);

    /**
     * @param todo edited Todo object
     * @return edited todo
     */
    Todo editTodo(Todo todo);

    /**
     * @param id Todo obejct id
     * @return Todo object
     */
    Todo findTodo(int id);

    /**
     * @return all Todo objects
     */
    List<Todo> getAll();

    /**
     * @param status Todo status
     * @return all  Todo objects by status
     */
    List<Todo> findByStatus(String status);

    /**
     * @param userId The user id
     * @param status The Todo status
     * @return all  Todo objects by user_id and todo status
     */
    List<Todo> findByUserIdStatus(int userId, String status);

}
