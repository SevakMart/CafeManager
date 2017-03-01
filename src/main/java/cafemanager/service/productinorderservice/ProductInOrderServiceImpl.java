package cafemanager.service.productinorderservice;

import cafemanager.dao.productsinorderdao.ProductsInOrderDao;
import cafemanager.model.ProductInOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {


    @Autowired
    private ProductsInOrderDao productsInOrderDao;

    /**
     * save product in order into db
     * @param entity is product in order
     */
    @Override
    public void create(ProductInOrder entity) {
        productsInOrderDao.create(entity);
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
