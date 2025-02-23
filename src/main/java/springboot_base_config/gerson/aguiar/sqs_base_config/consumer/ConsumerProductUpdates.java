package springboot_base_config.gerson.aguiar.sqs_base_config.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerProductUpdates {

    @SqsListener("queue-product-update")
    public void  receiveMessage(ConsumerProductUpdates message) {
        System.out.println("Message received: ");
    }
}
