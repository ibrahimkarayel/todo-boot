package com.pironix.service.impl;

import com.pironix.model.Todo;
import com.pironix.model.Users;
import com.pironix.repository.TodoRepository;
import com.pironix.repository.UserRepository;
import com.pironix.service.TodoService;
import com.pironix.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    @Autowired
    protected TodoRepository todoRepository;


    @Override
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Boolean deleteTodo(int id) {
        Todo todo = todoRepository.findOne(id);
        if (todo != null) {
            todoRepository.delete(todo);
            return true;
        }
        return false;
    }

    @Override
    public Todo editTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo findTodo(int id) {
        return todoRepository.findOne(id);
    }

    @Override
    public List<Todo> getAll() {
        return (List<Todo>) todoRepository.findAll();
    }

    @Override
    public List<Todo> findByStatus(String status) {
        return (List<Todo>) todoRepository.findByStatus(status);
    }

    @Override
    public List<Todo> findByUserIdStatus(int userId, String status) {
        return (List<Todo>) todoRepository.findByUserIdStatus(userId, status);
    }
}
