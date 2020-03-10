package com.wwy.consumer.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wwy.provider.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Reference
    TicketService ticketService;

    public void hello(){
        String msg = ticketService.getTicket();
        System.out.println("买到票了： "+msg);
    }
}
