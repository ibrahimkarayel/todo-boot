package com.pironix.controller;

import com.pironix.model.Users;
import com.pironix.service.UsersService;
import com.pironix.utils.PassEncoding;
import com.pironix.utils.Roles;
import com.pironix.utils.TodoCategories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Collections;
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
public class ModelController {

    @ModelAttribute("categories")
    public List<TodoCategories> populateCategories() {
        List<TodoCategories> categories = new ArrayList<>();
        Collections.addAll(categories, TodoCategories.values());
        return categories;

    }
}
