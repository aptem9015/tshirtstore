package com.example.tshirtstore.controllers;

import com.example.tshirtstore.entities.Order;
import com.example.tshirtstore.services.OrderService;
import com.example.tshirtstore.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class OrderController {

    private OrderService orderService;
    private ProductService productService;

    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
        this.productService = productService;
    }


    @RequestMapping(value = "/{id}/add_order", method = RequestMethod.GET)
    public String addOrder(@PathVariable(value = "id") String id,Model model) {
        model.addAttribute("order", new Order());
        productService.getProductById(new Long(id)).ifPresent(o -> model.addAttribute("product", o));
        return "add_order";
    }

    @GetMapping("/admin/orders")
    public String showOrders(Model model) {
        model.addAttribute("orders", orderService.getAllOrders());
        return "admin/orders";
    }


    @RequestMapping(value = "/{id}/add_order", method = RequestMethod.POST)
    public String addOrderSubmit(@Valid Order order, @PathVariable(value = "id") String id, BindingResult result) {
        if (result.hasErrors()) {
            return "/{id}/add_order";
        } else {
            productService.getProductById(new Long(id)).ifPresent(o -> order.setProduct(o));
            orderService.saveOrder(order);
            return "redirect:/";
        }
    }
}
