package cafemanager.dao.productsinorderdao;

import cafemanager.model.ProductInOrder;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Repository
public class ProductsInOrderDaoImpl implements ProductsInOrderDao {

    private static Logger logger = Logger.getLogger(ProductsInOrderDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void create(ProductInOrder entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        logger.info(entity+" product in order saved into db");
    }

    @Override
    public void update(ProductInOrder entity) {

    }

    @Override
    public void delete(ProductInOrder entity) {

    }

    @Override
    public ProductInOrder get(long id) {
        return null;
    }

    @Override
    public List<ProductInOrder> getAll() {
        return null;
    }
}
