package cafemanager.controller;

import cafemanager.model.Product;
import cafemanager.service.productservice.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

/**
 * Created by Sevak on 2/25/2017.
 */
@Controller
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public ModelAndView addProduct(@ModelAttribute("product") @Valid Product product, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("/manager/addProduct");
        }
        productService.create(product);
        return new ModelAndView("forward:/admin/showUser", "message", "product created  successfully");
    }
}
