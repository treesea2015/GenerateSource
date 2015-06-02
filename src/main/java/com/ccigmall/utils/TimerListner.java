package com.ccigmall.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ccigmall.beans.Scheduler;
import com.ccigmall.services.impl.SchedulerService;

public class TimerListner  implements ServletContextListener {
	private SchedulerService schedulerService;
    private Timer timer;
    // 一天的毫秒数
    private long daySpan = 24 * 60 * 60 * 1000;
    private final  Logger logger = LoggerFactory
			.getLogger(JobTimer.class);

    public TimerListner(){}
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        if (timer != null) {
            timer.cancel();
            event.getServletContext().log("定时器已销毁");
        }
    }

	@Override
	public void contextInitialized(ServletContextEvent event) {
		timer = new Timer(true);
		ApplicationContext context = new  ClassPathXmlApplicationContext(new String[]{"classpath:mvc-dispatcher-servlet.xml"});
		schedulerService = (SchedulerService) context.getBean("iSchedulerService");
		List<Scheduler> schedulerList = schedulerService.selectAll();
		if(schedulerList.size()>0){
			for(Scheduler scheduler : schedulerList){
				timer.scheduleAtFixedRate(new JobTimer(
						scheduler.getScheduler_id(),
						scheduler.getScheduler_name(),
						scheduler.getScheduler_bat(),
						scheduler.getStartTime()), 
						formatDate(scheduler.getStartTime()), daySpan);
				event.getServletContext().log("任务：["+scheduler.getScheduler_name()+"]已加入队列。");
			}
		}
		event.getServletContext().log("定时任务列表初始化成功！");
	}
	
	public Date formatDate(String time){
		Date startTime = null;
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd "+time);
		try {
			startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdf.format(new Date()));
		} catch (ParseException e) {
			logger.error("时间格式化失败！>>"+e.getMessage());
		}
		if (System.currentTimeMillis() > startTime.getTime()){
			startTime = new Date(startTime.getTime() + daySpan);
		}
		return startTime;
	}
	
}