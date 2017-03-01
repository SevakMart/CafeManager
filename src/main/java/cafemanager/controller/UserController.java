package cafemanager.controller;

import cafemanager.model.User;
import cafemanager.model.userrole.Roles;
import cafemanager.service.userservice.UserService;
import cafemanager.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Sevak on 2/25/2017.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private Validator validator;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("user") @Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("/manager/addWaiter");
        }
        if (validator.isUsernameExist(user.getUserName()))
            return new ModelAndView("forward:/admin/showUser", "message", "waiter with this name is already exist");
        user.setRole(Roles.WAITER);
        userService.create(user);
        return new ModelAndView("forward:/admin/showUser", "message", "waiter created  successfully");
    }


}
