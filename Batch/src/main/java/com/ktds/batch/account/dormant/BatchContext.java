package com.ktds.batch.account.dormant;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BatchContext {

	private static AbstractApplicationContext ctx;

	public static void start() {
		if (ctx == null) {
			ctx = new GenericXmlApplicationContext("classpath:/rootContext.xml", "classpath:/jobScheduler.xml");
		}
	}

	public static <T> T getBean(String beanName) {
		return (T) ctx.getBean(beanName);
	}

}
