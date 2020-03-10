package com.wwy.rabbit;

import com.wwy.rabbit.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class RabbitmqApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	void create(){
		//创建一个Exchange
		Exchange exchange = new DirectExchange("exchange.tom");
		amqpAdmin.declareExchange(exchange);

		//创建一个Queue
		amqpAdmin.declareQueue(new Queue("tom"));

		//创建一个Binding，（绑定queue名，绑定类型，绑定exchange名，路由key路由用来匹配消息，参数）
		amqpAdmin.declareBinding(new Binding("tom",Binding.DestinationType.QUEUE,"exchange.tom","tom",null));
	}

	@Test
	void contextLoads() {



		//发送消息
//		rabbitTemplate.convertAndSend("exchange.direct","depp",new Book("hello","depp"));

		//接受消息
//		Object o = rabbitTemplate.receiveAndConvert("depp");
//		System.out.println(o.getClass());
//		System.out.println(o);


	}

}
