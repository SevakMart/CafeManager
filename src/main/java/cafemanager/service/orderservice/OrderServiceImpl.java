package cafemanager.service.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cafemanager.dao.orderdao.OrderDao;
import cafemanager.model.Order;

import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void create(Order entity) {
        orderDao.create(entity);
    }

    @Override
    public void update(Order entity) {
        orderDao.update(entity);
    }

    @Override
    public void delete(Order entity) {

    }

    @Override
    public Order get(long id) {
        return orderDao.get(id);
    }

    @Override
    public List<Order> getAll() {
        return null;
    }
}
