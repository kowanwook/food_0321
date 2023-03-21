package food.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import food.config.kafka.KafkaProcessor;
import food.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Deliveryconfimed'"
    )
    public void wheneverDeliveryconfimed_UpdateStatus(
        @Payload Deliveryconfimed deliveryconfimed
    ) {
        Deliveryconfimed event = deliveryconfimed;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + deliveryconfimed + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Foodpicked'"
    )
    public void wheneverFoodpicked_UpdateStatus(
        @Payload Foodpicked foodpicked
    ) {
        Foodpicked event = foodpicked;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + foodpicked + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Cookstarted'"
    )
    public void wheneverCookstarted_UpdateStatus(
        @Payload Cookstarted cookstarted
    ) {
        Cookstarted event = cookstarted;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + cookstarted + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}
