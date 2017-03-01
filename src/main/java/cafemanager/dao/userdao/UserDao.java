package cafemanager.dao.userdao;

import cafemanager.dao.GenericDao;
import cafemanager.model.User;

/**
 * Created by Sevak on 2/25/2017.
 */
public interface UserDao extends GenericDao<User> {

    User getUserByNameAndPassword(String userName, String password);
}
