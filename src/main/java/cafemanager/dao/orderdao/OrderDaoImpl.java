package cafemanager.dao.orderdao;


import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import cafemanager.model.Order;

import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Repository
public class OrderDaoImpl implements OrderDao {

    private static Logger logger = Logger.getLogger(OrderDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void create(Order entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        logger.info(entity+" order successfully saved into db");
    }

    @Override
    @Transactional
    public void update(Order entity) {
        Session session = sessionFactory.getCurrentSession();
        session.update(entity);
        logger.info(entity+" order successfully updated in db");
    }

    @Override
    public void delete(Order entity) {

    }

    @Override
    @Transactional
    public Order get(long id) {
        Session session = sessionFactory.getCurrentSession();
        logger.info(" get order by id" + id);
        return (Order) session.get(Order.class, id);
    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
