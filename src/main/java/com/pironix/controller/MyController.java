package com.pironix.controller;

import com.pironix.model.Todo;
import com.pironix.model.Users;
import com.pironix.service.TodoService;
import com.pironix.service.UsersService;
import com.pironix.utils.PassEncoding;
import com.pironix.utils.Roles;
import com.pironix.utils.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by ibrahim
 *
 * @author ibrahim KARAYEL
 * @version 1.0
 * @since 9/3/2016.
 */
@Controller
@ComponentScan
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Autowired
    UsersService userService;

    @Autowired
    TodoService todoService;

    private static Users loginUser = null;

    @RequestMapping("/")
    public String root(Model model) {
        model.addAttribute("reqUser", new Users());
        logger.info("root");
        return "login";
    }


    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("reqUser", new Users());
        logger.info("login");
        return "login";
    }

    @RequestMapping("/home")
    public String home(Model model) {

        if (loginUser == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            loginUser = userService.findByUsername(auth.getName());
        }
        model.addAttribute("reqTodo", new Todo());
        model.addAttribute("allTodo", todoService.findByUserIdStatus(loginUser.getId(), Status.ACTIVE.getValue()));
        model.addAttribute("allPassiveTodo", todoService.findByUserIdStatus(loginUser.getId(), Status.PASSIVE.getValue()));
        logger.info("home");
        return "home";
    }


    @RequestMapping("/admin")
    public String helloAdmin() {
        logger.info("admin");
        return "admin";
    }


    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("reqUser", new Users());
        logger.info("register");
        return "register";
    }

    @RequestMapping(value = {"/user/register"}, method = RequestMethod.POST)
    public String register(@ModelAttribute("reqUser") Users reqUser,
                           final RedirectAttributes redirectAttributes) {

        logger.info("/user/register");
        Users users = userService.findByUsername(reqUser.getUsername());
        if (users != null) {
            redirectAttributes.addFlashAttribute("saveUser", "exist-name");
            return "redirect:/register";
        }
        users = userService.findByEmail(reqUser.getEmail());
        if (users != null) {
            redirectAttributes.addFlashAttribute("saveUser", "exist-email");
            return "redirect:/register";
        }

        reqUser.setPassword(PassEncoding.getInstance().passwordEncoder.encode(reqUser.getPassword()));
        reqUser.setRole(Roles.ROLE_USER.getValue());

        if (userService.saveUser(reqUser) != null) {
            redirectAttributes.addFlashAttribute("saveUser", "success");
        } else {
            redirectAttributes.addFlashAttribute("saveUser", "fail");
        }

        return "redirect:/register";
    }


    @RequestMapping(value = {"/user/saveTodo"}, method = RequestMethod.POST)
    public String saveTodo(@ModelAttribute("reqTodo") Todo reqTodo,
                           final RedirectAttributes redirectAttributes) {
        logger.info("/user/saveTodo");
        try {
            reqTodo.setCreatedDate(new Date());
            reqTodo.setStatus(Status.ACTIVE.getValue());
            reqTodo.setUserId(loginUser.getId());
            todoService.saveTodo(reqTodo);
            redirectAttributes.addFlashAttribute("saveTodo", "success");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("saveTodo", "fail");
            logger.error("saveTodo: " + e.getMessage());
        }

        return "redirect:/home";
    }


    @RequestMapping(value = {"/user/editTodo"}, method = RequestMethod.POST)
    public String editTodo(@ModelAttribute("editTodo") Todo editTodo,
                           final RedirectAttributes redirectAttributes) {
        logger.info("/user/editTodo");
        try {
            todoService.editTodo(editTodo);
            redirectAttributes.addFlashAttribute("editTodo", "success");

        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("editTodo", "fail");
            logger.error("editTodo: " + e.getMessage());
            return "redirect:/edit";
        }

        return "redirect:/home";
    }


    @RequestMapping(value = "/todo/{operation}/{id}", method = RequestMethod.GET)
    public String todoOperation(@PathVariable("operation") String operation,
                                @PathVariable("id") int id, final RedirectAttributes redirectAttributes,
                                Model model) {

        logger.info("/todo/{operation}: " + operation);
        if (operation.equals("trash")) {
            Todo todo = todoService.findTodo(id);
            if (todo != null) {
                todo.setStatus(Status.PASSIVE.getValue());
                todoService.editTodo(todo);
                redirectAttributes.addFlashAttribute("trash", "trash");
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        if (operation.equals("restore")) {
            Todo todo = todoService.findTodo(id);
            if (todo != null) {
                todo.setStatus(Status.ACTIVE.getValue());
                todoService.editTodo(todo);
                redirectAttributes.addFlashAttribute("trash", "trash");
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        } else if (operation.equals("delete")) {

            if (todoService.deleteTodo(id)) {
                redirectAttributes.addFlashAttribute("deletion", "del");
            } else {
                redirectAttributes.addFlashAttribute("deletion", "del-error");
            }
        } else if (operation.equals("edit")) {
            Todo editTodo = todoService.findTodo(id);
            if (editTodo != null) {
                model.addAttribute("editTodo", editTodo);
                return "edit";
            } else {
                redirectAttributes.addFlashAttribute("status", "notfound");
            }
        }
        return "redirect:/home";
    }


}
