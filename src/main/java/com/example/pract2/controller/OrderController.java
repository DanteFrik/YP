package com.example.pract2.controller;

import com.example.pract2.dao.OrderDAO;
import com.example.pract2.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderController(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("orders", orderDAO.getAll());
        return "orders/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        OrderModel order = orderDAO.getById(id);
        model.addAttribute("order", order);
        return "orders/show";
    }

    @GetMapping("/new")
    public String newOrderForm(Model model) {
        model.addAttribute("order", new OrderModel());
        return "orders/new";
    }

    @PostMapping
    public String create(@ModelAttribute("order") OrderModel order) {
        orderDAO.create(order);
        return "redirect:/orders";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable("id") int id, Model model) {
        OrderModel order = orderDAO.getById(id);
        model.addAttribute("order", order);
        return "orders/edit";
    }

    @PutMapping("/{id}")
    public String update(@ModelAttribute("order") OrderModel order, @PathVariable("id") int id) {
        orderDAO.update(id, order);
        return "redirect:/orders";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        orderDAO.delete(id);
        return "redirect:/orders";
    }
}
