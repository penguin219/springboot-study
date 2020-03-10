package com.wwy.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {

    //通过cron表达式实现定时任务
    //支持设置 second、minute、hour、day of month、month、day of week
    //下面cron表达式表示 从周一到周六每整分运行一次
    @Scheduled(cron="0 * * * * 0-7")
    public void hello(){
        System.out.println("hello....");
    }

}
