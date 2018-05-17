package com.fengyu.test;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SchedularTest {
	@Scheduled(cron="1 * * * * ?")
	public void testScedular() {
		System.out.println("我就是spring的定时任务");
	}

}
