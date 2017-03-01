package cafemanager.validation;

import cafemanager.model.Table;
import cafemanager.model.User;
import cafemanager.service.tableservice.TableService;
import cafemanager.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Sevak on 2/26/2017.
 */
@Component
public class Validator {
    @Autowired
    private UserService userService;

    @Autowired
    private TableService tableService;

    public boolean isUsernameExist(String userName) {
        List<User> all = userService.getAll();
        for (User user : all) {
            if (user.getUserName().equals(userName)) return true;
        }
        return false;
    }

    public boolean isTableNumberExist(int tableNumber) {
        List<Table> tables = tableService.getAll();
        for (Table table : tables) {
            if (table.getTableNumber() == tableNumber) return true;
        }
        return false;
    }
}
