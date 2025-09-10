package com.microservice.kafka.ProductsMicroservice.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.microservice.kafka.ProductsMicroservice.rest.CreateProductRestModel;

@Service
public class ProductServiceImpl implements ProductService {

    KafkaTemplate<String, ProductCreatedEvent> kafkaTemplate;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    
    public ProductServiceImpl(KafkaTemplate<String,ProductCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public String createProduct(CreateProductRestModel productRestModel) throws Exception {

        String productId = UUID.randomUUID().toString();

        //TODO: persist product details into db table before publish the event

        ProductCreatedEvent productCreatedEvent = new ProductCreatedEvent(
            productId,
            productRestModel.getTitle(),
            productRestModel.getPrice(),
            productRestModel.getQuantity());

        SendResult<String, ProductCreatedEvent> result = kafkaTemplate.send("product-created-events-topic", productId, productCreatedEvent).get();


        LOGGER.info("******Returning product id");

        return productId;
    }


}
