package app.controller;


import app.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
public class UserController {
    private static final Logger LOGGER = Logger.getLogger("UserController");
    private final UserDAO userDAO;

    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping(value = "/")
    public String goUsers(Model model) {
        LOGGER.log(Level.INFO, "start");
        model.addAttribute(userDAO.getUsers());
        return "users";
    }

}