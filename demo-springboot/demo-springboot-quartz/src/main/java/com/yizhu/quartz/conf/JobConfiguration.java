package com.yizhu.quartz.conf;

import com.yizhu.quartz.job.DemoJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration{

    @Value("${demoJob.crons}")
    private String crons;

    @Value("${demoJob.param1}")
    private String param1;
    
    /**
     * 指定定时任务具体的类
     */
    @Bean
    public JobDetail quartzTaskJobDetail() {
        return JobBuilder
                .newJob(DemoJob.class)
                .withIdentity("demoJob")
                .usingJobData("param1", param1)
                .storeDurably()
                .build();
    }

    /**
     * 指定定时任务触发的机制
     */
    @Bean
    public Trigger quartzTaskTrigger() {
        // CronScheduleBuilder指定job触发机制
        CronScheduleBuilder scheduleBuilder1 = CronScheduleBuilder.cronSchedule("*/1 * * * * ?");
        // CronScheduleBuilder指定job触发机制，从配置文件读
        CronScheduleBuilder scheduleBuilder2 = CronScheduleBuilder.cronSchedule(crons);

        // SimpleScheduleBuilder指定job触发方式
        SimpleScheduleBuilder scheduleBuilder3 = SimpleScheduleBuilder
                .simpleSchedule()
                .withIntervalInSeconds(1)
                .repeatForever();

        // CalendarIntervalScheduleBuilder指定job触发方式
        CalendarIntervalScheduleBuilder scheduleBuilder4 = CalendarIntervalScheduleBuilder
                .calendarIntervalSchedule()
                .withInterval(1,DateBuilder.IntervalUnit.SECOND);
        // DailyTimeIntervalScheduleBuilder指定job触发方式
        DailyTimeIntervalScheduleBuilder scheduleBuilder5 = DailyTimeIntervalScheduleBuilder
                .dailyTimeIntervalSchedule()
                .withInterval(1,DateBuilder.IntervalUnit.SECOND);

        return TriggerBuilder
                .newTrigger()
                .forJob(quartzTaskJobDetail())
                .withIdentity("demoTrigger")
                .withSchedule(scheduleBuilder2)
                .build();
    }
}
