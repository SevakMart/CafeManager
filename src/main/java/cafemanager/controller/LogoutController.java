package cafemanager.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by Sevak on 2/25/2017.
 */


@Controller
public class LogoutController {

    private static Logger logger = Logger.getLogger(LogoutController.class);
    /**
     * invalidate the current session and redirect to login page
     */
    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        logger.info("user is logged out");
        return new ModelAndView("/login");
    }
}
