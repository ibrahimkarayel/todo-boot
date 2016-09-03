package com.pironix.controller;

import com.pironix.Application;
import com.pironix.model.Todo;
import com.pironix.model.Users;
import com.pironix.service.TodoService;
import com.pironix.service.UsersService;
import com.pironix.utils.Roles;
import com.pironix.utils.Status;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ibrahim KARAYEL
 *
 * @version 1.0
 * @since 9/3/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class ModelControllerTest {

    @Autowired
    UsersService usersService;
    @Autowired
    TodoService todoService;

    private static List<Users> usersList;
    private static List<Todo> todoList;

    @BeforeClass
    public static void oneTimeSetUp() {
        // one-time initialization code
        System.out.println("@BeforeClass - oneTimeSetUp");
        usersList = new ArrayList<>();
        Users user;
        for (int i = 0; i < 6; i++) {
            user = new Users("test_user_" + i, "test_passw" + i, "test" + i + "@gmail.com", Roles.ROLE_USER.getValue());
            usersList.add(user);
        }


        todoList = new ArrayList<>();
        Todo todo;
        for (int i = 0; i < 5; i++) {
            todo = new Todo();
            todo.setStatus(Status.ACTIVE.getValue());
            todo.setCreatedDate(new Date());
            todo.setTaskDate(new Date());
            todo.setTodoName("Test Todo" + i);
            todo.setDescription("Test Desc" + i);
            todo.setContent("Test Todo Content " + i);
            todoList.add(todo);
        }
    }

    @AfterClass
    public static void oneTimeTearDown() {
        // one-time cleanup code
        System.out.println("@AfterClass - oneTimeTearDown");
        usersList = null;
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("@Before - PassEncodingTest setUp");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("@After - PassEncodingTest tearDown");
    }

    @Test
    public void testSaveUser() {
        Users user = usersList.get(0);
        Users save = usersService.saveUser(user);
        assertNotNull(save);


    }

    @Test
    public void testDeleteUser() {
        Users user = usersList.get(1);
        Users save = usersService.saveUser(user);
        assertNotNull(save);
        assertEquals(usersService.deleteUser(user.getId()), true);
    }

    @Test
    public void testUpdateUser() {
        Users user = usersService.saveUser(usersList.get(2));
        assertEquals(user.getEmail(), "test2@gmail.com");
        user.setEmail("update@gmail.com");
        Users update = usersService.editUser(user);
        assertEquals(update.getEmail(), "update@gmail.com");
    }


    @Test
    public void testAddTodo() {
        Users user = usersService.saveUser(usersList.get(3));
        Todo todo = todoList.get(0);
        todo.setUserId(user.getId());
        assertNotNull(todoService.saveTodo(todo));


    }

    @Test
    public void testDeleteTodo() {
        Users user = usersService.saveUser(usersList.get(4));
        Todo todo = todoList.get(1);
        todo.setUserId(user.getId());
        assertNotNull(todoService.saveTodo(todo));
        assertTrue(todoService.deleteTodo(todo.getId()));

    }

    @Test
    public void testEditTodo() {
        Users user = usersService.saveUser(usersList.get(5));
        Todo todo = todoList.get(2);
        todo.setUserId(user.getId());
        assertNotNull(todoService.saveTodo(todo));
        todo.setTodoName("updateTodoName");
        Todo update=todoService.editTodo(todo);
        assertEquals(update.getTodoName(), "updateTodoName");
    }
}