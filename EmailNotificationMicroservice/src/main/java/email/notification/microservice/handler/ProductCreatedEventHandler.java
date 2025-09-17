package email.notification.microservice.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@KafkaListener()
public class ProductCreatedEventHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @KafkaListener(topics="product-created-events-topic")
    public void handler(ProductCreateEvent ProductCreateEvent) {
        LOGGER.info("Received a new event: " + ProductCreateEvent.getTitle());
    }

}
