package cafemanager.service.userservice;

import cafemanager.dao.tabledao.TableDao;
import cafemanager.dao.userdao.UserDao;
import cafemanager.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cafemanager.model.User;

import javax.naming.OperationNotSupportedException;
import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     *
     * @param userName
     * @param password
     * @return user by user name and password if it`s exist
     */

    @Override
    public User getUserByNameAndPassword(String userName, String password) {
        return userDao.getUserByNameAndPassword(userName, password);
    }

    /**
     * add user into db
     *
     * @param entity insert user
     */

    @Override
    public void create(User entity) {
        userDao.create(entity);
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    /**
     * get user from db by id
     * @param id user's id
     * @return User object when user email and password is match
     */
    @Override
    public User get(long id) {

        return userDao.get(id);
    }
    /**
     * get all users from db
     * @return List of all User objects
     */
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }
}
