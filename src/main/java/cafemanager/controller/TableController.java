package cafemanager.controller;

import cafemanager.model.Table;
import cafemanager.model.User;
import cafemanager.model.tablestatus.TableStatus;
import cafemanager.service.tableservice.TableService;
import cafemanager.service.userservice.UserService;
import cafemanager.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Sevak on 2/25/2017.
 */
@Controller
@RequestMapping(value = "/table")
public class TableController {

    @Autowired
    private TableService tableService;

    @Autowired
    private UserService userService;

    @Autowired
    private Validator validator;


    @RequestMapping(value = "/admin/create", method = RequestMethod.POST)
    public ModelAndView createTable(@ModelAttribute("table") @Valid Table table, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("/manager/addTable");
        }
        if (validator.isTableNumberExist(table.getTableNumber()))
            return new ModelAndView("forward:/admin/showTable", "message", "table with this number already exist");
        table.setTableStatus(TableStatus.FREE);
        tableService.create(table);
        return new ModelAndView("forward:/admin/showTable", "message", "table created  successfully");
    }

    @RequestMapping(value = "/assignTo")
    public ModelAndView assignTableToWaiter(@RequestParam("waiterId") int waiterId, @RequestParam("tableId") int tableId) {
        User user = userService.get(waiterId);
        if (user != null) {
            Table table = tableService.get(tableId);
            if (table != null) {
                table.setWaiter(user);
                table.setTableStatus(TableStatus.OCCUPIED);
                tableService.update(table);
                return new ModelAndView("forward:/admin/showAssignTo", "message", "table assigned to waiter successfully");
            }
        }
        return new ModelAndView("forward:/admin/showAssignTo", "message", "table assigned to waiter failed");
    }

    @RequestMapping(value = "/showOrders/{tableId}")
    public ModelAndView showTableOrders(@PathVariable("tableId") int tableId) {
        Table table = tableService.get(tableId);
        if (table != null) {
            return new ModelAndView("/waiter/tableOrders", "table", table);
        }
        return new ModelAndView("forward:/water/showPage", "message", "there are no table with this id");
    }
}
