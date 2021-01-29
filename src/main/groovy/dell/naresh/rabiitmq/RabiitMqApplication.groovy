package dell.naresh.rabiitmq

import dell.naresh.rabiitmq.config.MessageConfig
import dell.naresh.rabiitmq.domain.Order
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class RabiitMqApplication {

	static void main(String[] args) {
		SpringApplication.run(RabiitMqApplication, args)
	}
	@RabbitListener(queues = MessageConfig.QUEUE)
	public static void listen(Order value) {
		System.out.println("Message read from myQueue : " + value);
	}
}
