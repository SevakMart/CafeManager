package cafemanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sevak on 2/25/2017.
 */
@Controller
@RequestMapping(value = "/waiter")
public class WaiterController {

    @RequestMapping(value = "/showPage")
    public ModelAndView showWaiterPage(){
        return new ModelAndView("/waiter/waiter");
    }
}
