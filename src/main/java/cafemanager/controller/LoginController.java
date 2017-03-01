package cafemanager.controller;

import cafemanager.model.User;
import cafemanager.model.userrole.Roles;
import cafemanager.service.userservice.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Sevak on 2/25/2017.
 */
@Controller
public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    /**
     * check if there is user with this username and password
     * redirect to appropriate  page
     * @param userName
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("userName") String userName,
                              @RequestParam("password") String password,
                              HttpSession session) {

        User user = userService.getUserByNameAndPassword(userName, password);
        if (user != null) {
            session.setMaxInactiveInterval(3600);
            session.setAttribute("user", user);
            logger.info("open session for user: " + user);
            if (user.getRole() == Roles.MANAGER) {
                return new ModelAndView("/manager/manager");
            } else {
                return new ModelAndView("redirect:/waiter/showPage");
            }
        }
        return new ModelAndView("/login","message", "there are no user with this email and password");
    }
}
