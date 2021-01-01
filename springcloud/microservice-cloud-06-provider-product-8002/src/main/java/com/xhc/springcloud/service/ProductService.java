package com.xhc.springcloud.service;


import com.xhc.springcloud.entities.Product;

import java.util.List;

/**
 * @Auther: xhc
 */
public interface ProductService {

    boolean add(Product product);

    Product get(Long id);

    List<Product> list();

}
