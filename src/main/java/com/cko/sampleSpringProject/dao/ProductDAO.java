package com.cko.sampleSpringProject.dao;
import com.cko.sampleSpringProject.model.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductDAO extends CrudRepository<Product, Long> {

    Product findProductById(Long id);

    Product findProductByName(String name);
    Product findProductByPrice(int price);
    Product findProductByAmount(int amount);
    List<Product> findAll();

}
