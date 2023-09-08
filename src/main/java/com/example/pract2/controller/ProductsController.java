package com.example.pract2.controller;

import com.example.pract2.dao.ProductDAO;
import com.example.pract2.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private final ProductDAO productDAO;

    @Autowired
    public ProductsController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("products", productDAO.getAll());
        return "products/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        ProductModel product = productDAO.getById(id);
        model.addAttribute("product", product);
        return "products/show";
    }

    @GetMapping("/new")
    public String newProductForm(Model model) {
        model.addAttribute("product", new ProductModel());
        return "products/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("product") ProductModel product) {
        productDAO.create(product);
        return "redirect:/products";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        ProductModel product = productDAO.getById(id);
        model.addAttribute("product", product);
        return "products/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("product") ProductModel product, @PathVariable("id") int id) {
        productDAO.update(id, product);
        return "redirect:/products";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        productDAO.delete(id);
        return "redirect:/products";
    }
}
