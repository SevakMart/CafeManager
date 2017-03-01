package cafemanager.dao.userdao;

import cafemanager.model.userrole.Roles;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import cafemanager.model.User;

import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Repository
public class UserDaoImpl implements UserDao {

    private static Logger logger = Logger.getLogger(UserDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void create(User entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        logger.info(entity + " saved into db");
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(User entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
        logger.info(entity + " updated in db");
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    @Transactional
    public User get(long id) {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get user by id: " + id);
        return (User) session.get(User.class, id);
    }

    @Override
    @Transactional
    public List<User> getAll() {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get all users from db");
        return session.createCriteria(User.class).add(Restrictions.eq("role", Roles.WAITER)).list();
    }

    @Override
    @Transactional
    public User getUserByNameAndPassword(String userName, String password) {
        logger.info("get user by username: " + userName + " and password: " + password);
        Session session = sessionFactory.getCurrentSession();
        return (User) session.createCriteria(User.class).add(Restrictions.eq("userName", userName)).add(Restrictions.eq("password", password)).uniqueResult();
    }
}
