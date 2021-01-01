package com.xhc.springcloud.mapper;

import com.xhc.springcloud.entities.Product;

import java.util.List;

/**
 * @Auther: xhc
 */

//@Mapper //或者在启动类上标识 @MapperScan
public interface ProductMapper {
    Product findById(Long pid);

    List<Product> findAll();

    boolean addProduct(Product product);
}