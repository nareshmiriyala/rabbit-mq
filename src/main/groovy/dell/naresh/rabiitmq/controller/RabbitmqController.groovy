package dell.naresh.rabiitmq.controller

import groovy.util.logging.Slf4j

import dell.naresh.rabiitmq.config.MessageConfig
import dell.naresh.rabiitmq.domain.Order
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/api/v1.0/rb")
@RestController
@Slf4j
class RabbitmqController {
    @Autowired
    RabbitTemplate template

    @GetMapping
    public void send() {
        log.info("Sending message")
        Order order = new Order()
        order.orderId = "343243"
        order.name = "Belt"
        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY, order)
    }
}
