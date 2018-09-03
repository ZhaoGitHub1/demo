package com.yizhu.quartz.job;

import com.yizhu.quartz.service.DemoService;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.quartz.QuartzJobBean;

@DisallowConcurrentExecution// 禁止并发运行同一个jobDetail
public class DemoJob extends QuartzJobBean {

    @Autowired
    private DemoService demoService;

    private String param1;

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    @Value("${demoJob.param2}")
    private String param2;


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        demoService.doSomething(param1, param2);
    }
}
