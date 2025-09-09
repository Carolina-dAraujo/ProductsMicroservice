package com.microservice.kafka.ProductsMicroservice.service;

import org.springframework.stereotype.Service;

import com.microservice.kafka.ProductsMicroservice.rest.CreateProductRestModel;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public String createProduct(CreateProductRestModel productRestModel) {
        return null;
    }


}
