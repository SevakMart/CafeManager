package cafemanager.controller;

import cafemanager.model.Order;
import cafemanager.model.Product;
import cafemanager.model.ProductInOrder;
import cafemanager.model.orderstatus.OrderStatus;
import cafemanager.service.orderservice.OrderService;
import cafemanager.service.productinorderservice.ProductInOrderService;
import cafemanager.service.productservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Controller
@RequestMapping("/productInOrder")
public class ProductInOrderController {

    @Autowired
    private ProductInOrderService productInOrderService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/showPage/{tableId}/{orderId}")
    public ModelAndView showProductInOrderPage(@PathVariable("orderId") int orderId, @PathVariable("tableId") int tableId, Model model) {
        Order order = orderService.get(orderId);
        if (order != null && order.getOrderStatus() == OrderStatus.OPEN) {
            List<Product> products = productService.getAll();
            model.addAttribute("products", products);
            model.addAttribute("order", order);
            return new ModelAndView("/waiter/addProductInOrder");
        }
        return new ModelAndView("forward:/table/showOrders/" + tableId, "message", "show product in order page failed");
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addProductInOrder(@RequestParam("productId") int productId, @RequestParam("orderId") int orderId,
                                          @RequestParam("amount") int amount) {
        if (amount < 1) return new ModelAndView("forward:/waiter/showPage", "message", "add product in order failed ");
        Order order = orderService.get(orderId);
        Product product = productService.get(productId);
        if (product != null && order != null) {
            ProductInOrder productInOrder = new ProductInOrder();
            productInOrder.setProduct(product);
            productInOrder.setProductOrder(order);
            productInOrder.setAmount(amount);
            productInOrderService.create(productInOrder);
            long tableId = order.getTable().getId();
            return new ModelAndView("forward:/productInOrder/showPage/" + tableId + "/" + orderId);
        }
        return new ModelAndView("forward:/waiter/showPage", "message", "add product in order failed ");
    }
}
