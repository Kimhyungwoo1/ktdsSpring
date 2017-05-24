package com.ktds.batch.account.dormant;

import java.util.function.Consumer;
import java.util.stream.Stream;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.ktds.batch.account.dormant.biz.DormantAccountBiz;
import com.ktds.batch.account.dormant.vo.UsersVO;

public class DormantAccountJob extends QuartzJobBean {

	private DormantAccountBiz dormantAccountBiz;
	
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

		dormantAccountBiz = BatchContext.getBean("dormantAccountBizImpl");
		
		Stream<UsersVO> usersVO = dormantAccountBiz.getAllDormantAccounts();
		usersVO.forEach(new Consumer<UsersVO>() {

			@Override
			public void accept(UsersVO t) {
				System.out.println(t.getUserId());
			}

		});
	}

}
