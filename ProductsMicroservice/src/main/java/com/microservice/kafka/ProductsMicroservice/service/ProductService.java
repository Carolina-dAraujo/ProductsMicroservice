package com.microservice.kafka.ProductsMicroservice.service;

import com.microservice.kafka.ProductsMicroservice.rest.CreateProductRestModel;

public interface ProductService {

    String createProduct(CreateProductRestModel productRestModel);

}
