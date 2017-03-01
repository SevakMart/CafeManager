package cafemanager.controller;

import cafemanager.model.Product;
import cafemanager.model.Table;
import cafemanager.model.User;
import cafemanager.service.tableservice.TableService;
import cafemanager.service.userservice.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Controller
@RequestMapping(value = "/admin")
public class ManagerController {


    @Autowired
    private UserService userService;

    @Autowired
    private TableService tableService;

    /**
     * redirecting to add waiter page
     * @return
     */
    @RequestMapping(value = "/showUser")
    public ModelAndView showAddUserPage() {
        return new ModelAndView("/manager/addWaiter", "user", new User());
    }

    /**
     * redirecting to add table page
     * @return
     */
    @RequestMapping(value = "/showTable")
    public ModelAndView showAddTablePage() {
        return new ModelAndView("/manager/addTable", "table", new Table());
    }

    /**
     * redirecting to add product page
     * @return
     */
    @RequestMapping(value = "/showProduct")
    public ModelAndView showAddProductPage() {
        return new ModelAndView("/manager/addProduct", "product", new Product());
    }

    /**
     * redirecting to assign table to waiter page
     * @param model
     * @return
     */
    @RequestMapping(value = "/showAssignTo")
    public ModelAndView assignTableToWaiter(Model model) {
        List<User> users = userService.getAll();
        List<Table> tables = tableService.getAll();
        model.addAttribute("users", users);
        model.addAttribute("tables", tables);
        return new ModelAndView("/manager/assignToWaiter");
    }
}
