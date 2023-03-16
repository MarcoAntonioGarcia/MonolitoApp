package com.springboot.monolito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.monolito.entity.Product;
import com.springboot.monolito.repository.ProductRepository;

@Service
@Transactional
public class ProductService {
 
    @Autowired
    private ProductRepository repo;
     
    public List<Product> listAll() {
        return repo.findAll();
    }
     
    public void save(Product product) {
        repo.save(product);
    }
     
    public Product get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
    
    public List<Product> byBrand(String brand) {
    	return repo.findByBrand(brand);
    }
    
    public List<Product> byPriceGreaterThan(float price){
    	return repo.findByPriceGreaterThan(price);
    }
    
    
}