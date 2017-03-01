package cafemanager.service.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cafemanager.dao.productdao.ProductDao;
import cafemanager.model.Product;

import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    /**
     * save product entity into db
     * @param entity is product entity
     */
    @Override
    public void create(Product entity) {
        productDao.create(entity);
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void delete(Product entity) {

    }

    /**
     * get product by id
     * @param id is entity id
     * @return product
     */
    @Override
    public Product get(long id) {
        return productDao.get(id);
    }

    /**
     * get all products from db
     * @return List of products
     */
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }
}
