package cafemanager.service.userservice;


import cafemanager.model.User;
import cafemanager.service.GenericService;

/**
 * Created by Sevak on 2/25/2017.
 */
public interface UserService extends GenericService<User> {
    User getUserByNameAndPassword(String userName, String password);


}
