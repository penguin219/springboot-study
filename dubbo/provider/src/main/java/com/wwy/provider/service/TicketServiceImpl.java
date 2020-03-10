package com.wwy.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.stereotype.Component;

@Component
@Service
public class TicketServiceImpl implements  TicketService {
    @Override
    public String getTicket() {
        return "<棉花糖>";
    }
}
