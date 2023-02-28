package com.example.demo.Services;

import com.example.demo.Entity.Product;
import com.example.demo.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    ProductRepository productRepository;

    public List<Product> listProduct(){
        return productRepository.findAll();
    }

    public Optional<Product> getProduct(int idProduct){
        return productRepository.findById(idProduct);
    }

    public void saveProduct(Product product){
        productRepository.save(product);
    }

    public boolean existsByIdProduct(int idProduct){
        return productRepository.existsById(idProduct);
    }
}
