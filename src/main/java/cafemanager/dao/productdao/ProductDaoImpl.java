package cafemanager.dao.productdao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import cafemanager.model.Product;

import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Repository
public class ProductDaoImpl implements ProductDao {

    private static Logger logger = Logger.getLogger(ProductDaoImpl.class);

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void create(Product entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        logger.info(entity + " saved in db");
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void delete(Product entity) {

    }

    @Override
    @Transactional
    public Product get(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        logger.info("get product by id: " + id);
        return (Product) currentSession.get(Product.class, id);
    }

    @Override
    @Transactional
    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get all products from db");
        return session.createCriteria(Product.class).list();
    }
}
