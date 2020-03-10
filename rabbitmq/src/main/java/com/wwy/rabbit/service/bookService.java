package com.wwy.rabbit.service;

import com.wwy.rabbit.bean.Book;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class bookService {
    @RabbitListener(queues="depp")
    public void recive(Book book){
        System.out.println("收到消息："+book);

    }
}
