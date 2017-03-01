package cafemanager.controller;

import cafemanager.model.Order;
import cafemanager.model.Table;
import cafemanager.model.orderstatus.OrderStatus;
import cafemanager.service.orderservice.OrderService;
import cafemanager.service.tableservice.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sevak on 2/25/2017.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private TableService tableService;

    /**
     * create order, add into order appropriate table
     * @param tableId
     * @return
     */
    @RequestMapping(value = "/crate/{tableId}")
    public ModelAndView createOrder(@PathVariable("tableId") int tableId) {
        Table table = tableService.get(tableId);
        if (table != null) {
            Order order = new Order();
            order.setTable(table);
            order.setOrderStatus(OrderStatus.OPEN);
            orderService.create(order);
            return new ModelAndView("forward:/waiter/showPage", "message", "order successfully created");
        }
        return new ModelAndView("forward:/waiter/showPage", "message", "failed to create order");
    }

    /**
     * change order status to CANCEL
     * @param orderId
     */
    @RequestMapping(value = "/cancel/{orderId}")
    public ModelAndView cancelOrder(@PathVariable("orderId") int orderId) {
        Order order = orderService.get(orderId);
        if (order != null) {
            order.setOrderStatus(OrderStatus.CANCELLED);
            long tableId = order.getTable().getId();
            orderService.update(order);
            return new ModelAndView("forward:/table/showOrders/" + tableId, "message", "the order cancelled successfully");
        }
        return new ModelAndView("forward:/waiter/showPage", "message", "cancel order is failed");

    }

    /**
     *  change order status to CLOSED
     * @param orderId
     */
    @RequestMapping(value = "/close/{orderId}")
    public ModelAndView closeOrder(@PathVariable("orderId") int orderId) {
        Order order = orderService.get(orderId);
        if (order != null) {
            order.setOrderStatus(OrderStatus.CLOSED);
            long tableId = order.getTable().getId();
            orderService.update(order);
            return new ModelAndView("forward:/table/showOrders/" + tableId, "message", "the order closed successfully");
        }
        return new ModelAndView("forward:/waiter/showPage", "message", "close order is failed");

    }

    /**
     * show order details
     * @param orderId
     */
    @RequestMapping(value = "/show/{orderId}")
    public ModelAndView showOrderDetails(@PathVariable("orderId") int orderId) {
        Order order = orderService.get(orderId);
        if (order != null) {
            return new ModelAndView("/waiter/orderDetails", "order", order);
        }
        return new ModelAndView("redirect:/waiter/showPage");
    }
}
