package com.springboot.monolito.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.monolito.entity.Product;
import com.springboot.monolito.service.ProductService;
import java.util.List;


@Controller
public class AppController {
 
    @Autowired
    private ProductService service;
     
    // handler methods...
    
    @RequestMapping("/products")
    public String viewHomePage(Model model) {
        List<Product> listProducts = service.listAll();
        model.addAttribute("listProducts", listProducts);
        return "index";
    }
    
    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
         
        return "new_product";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
         
        return "redirect:/products";
    }
    
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = service.get(id);
        mav.addObject("product", product);
         
        return mav;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/products";       
    }
    
    @RequestMapping("/brand/{brand}")
    public String byBrand(@PathVariable(name = "brand") String brand, Model model) {
    	List<Product> listProductsByBrand = service.byBrand(brand);
    	model.addAttribute("listProductsByBrand", listProductsByBrand);
        return "by_brand";       
    }
    
    @RequestMapping("/priceGreaterThan/{price}")
    public String byPriceGreaterThan(@PathVariable(name = "price") float price, Model model) {
    	List<Product> listProductsByPrice= service.byPriceGreaterThan(price);
    	model.addAttribute("listProductsByPrice", listProductsByPrice);
        return "by_price";       
    }
    
    
    
    
    
    
}