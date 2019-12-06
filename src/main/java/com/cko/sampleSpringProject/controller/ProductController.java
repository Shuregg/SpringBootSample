package com.cko.sampleSpringProject.controller;


import com.cko.sampleSpringProject.dao.ProductDAO;

import com.cko.sampleSpringProject.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductDAO productDAO;
    @GetMapping("/all")
    public ModelAndView showAllProductsPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("productsPage"); //Name of the HTML file
        List<Product> productsList = productDAO.findAll();
        modelAndView.addObject("products", productsList);

        return modelAndView;
    }

    @GetMapping("/new")
    public String showCreateProductPage() { return "newProduct";}

    @PostMapping("/new")
    public RedirectView addNewProduct(Product  product) {
        System.out.println(product.getName());

        return new RedirectView("/products/all");
    }

    @GetMapping("/editProduct")
    public ModelAndView showEditProductPage(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = productDAO.findProductById(id);
        modelAndView.addObject("product", product);
        modelAndView.setViewName("editProduct");
        return modelAndView;
    }

    @PostMapping("/editProduct")
    public RedirectView editProduct(Product product) {
        productDAO.save(product);
        return new RedirectView("/products/all");
    }

    @GetMapping("/deleteProduct")
    public RedirectView deleteProduct(@RequestParam Long id) {
        RedirectView redirectView = new RedirectView();
        productDAO.deleteById(id);
        return new RedirectView("/products/all");

    }
    @GetMapping("/buyProduct")
    public RedirectView buyProduct(@RequestParam Long id) {
        RedirectView redirectView = new RedirectView();
        productDAO.buyProduct(id);
        return new RedirectView("/products/all");
    }
    @PostMapping("/buyProduct")
    public RedirectView buyProduct(Product product) {
        productDAO.save(product);
        return new RedirectView("/products/all");
    }


}

