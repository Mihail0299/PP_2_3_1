package myProject.controller;

import myProject.model.User;
import myProject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //Таблица всех пользователей
    @RequestMapping(value = "/")
    public String viewUsers(ModelMap model) {
        model.addAttribute("tableOfUsers", userService.getUsers());
        return "index";
    }

    @RequestMapping("/signup")
    public String showSignUpForm(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    //Создает нового пользователя
    @PostMapping ("/saveuser")
    public String saveUser(@ModelAttribute ("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable(name = "id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }

    @RequestMapping("/updateUser/{id}")
    public String showUpdateUserForm(@PathVariable(name = "id") Long id, ModelMap model) {
//        User user = userService.getUserById(id);
        model.addAttribute("user",userService.getUserById(id));
        return "user-edit";
    }

    @PostMapping("/editUser")
    public String updateUser(@ModelAttribute("userr") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }
}

