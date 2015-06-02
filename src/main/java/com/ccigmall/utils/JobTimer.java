package com.ccigmall.utils;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoader;

public class JobTimer extends TimerTask {
	private  int schedulerId;
	private  String schedulerName;
	private  String schedulerBat;
	private  String startTime;
	private  RuntimeExecCommand runtimeExecCommand;
	private  String WEB_ROOT = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/");
	private  static boolean isRunning = false;
    private  final  Logger logger = LoggerFactory.getLogger(JobTimer.class);

    public JobTimer(int schedulerId,String schedulerName,String schedulerBat ,String startTime) {
        this.schedulerId = schedulerId;
        this.schedulerName = schedulerName;
        this.schedulerBat = schedulerBat;
        this.startTime = startTime;
    }

    @Override
    public void run() {
        if (!isRunning) {
            isRunning = true;
            runtimeExecCommand = new RuntimeExecCommand();
            logger.info("本次任务编号为：{},任务名称：{}",schedulerId,schedulerName);
            logger.info("执行bat脚本：{},设定触发时间为：{},启动完成..",schedulerBat.toString(),startTime);
    		String batFile = WEB_ROOT+schedulerName+".bat";
    		runtimeExecCommand.write(batFile, schedulerBat);
            runtimeExecCommand.execCommandFile(batFile);  
            isRunning = false;
        } else {
        	 logger.info("上次任务还在执行");
        }
    }

}