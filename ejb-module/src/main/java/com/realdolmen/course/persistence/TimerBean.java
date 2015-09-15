package com.realdolmen.course.persistence;

import sun.management.counter.Counter;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;

/**
 * Created by SDOAX36 on 14/09/2015.
 */

@Singleton
public class TimerBean {

    @Resource
    private TimerService timerService;

    @PostConstruct
    public void init()
    {
        String info = "IntervalTimer_info";
        timerService.createIntervalTimer(100000,2000000,new TimerConfig(info.toString(),true));
    }

    private int counter = 0;

    @Timeout
    public void timeout(Timer timer)
    {
        System.out.println("*********************************************");
        System.out.println("timer : "+timer.getInfo());
        System.out.println("Timer info : next timeout : " + timer.getNextTimeout() + " get time remaining : " + timer.getTimeRemaining());
        System.out.println("Counter value : "+counter++);
        System.out.println("*********************************************");
        if (counter == 20)
        {
            timer.cancel();
        }
    }
}
