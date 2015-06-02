package com.ccigmall.beans;

/**
 * 定时任务
 * @author treesea888@icloud.com
 * @description Scheduler
 */

public class Scheduler {

	private int scheduler_id;
	private String Scheduler_name;
	private String Scheduler_bat;
	private String startTime;
	public int getScheduler_id() {
		return scheduler_id;
	}
	public void setScheduler_id(int scheduler_id) {
		this.scheduler_id = scheduler_id;
	}
	public String getScheduler_name() {
		return Scheduler_name;
	}
	public void setScheduler_name(String scheduler_name) {
		Scheduler_name = scheduler_name;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getScheduler_bat() {
		return Scheduler_bat;
	}
	public void setScheduler_bat(String scheduler_bat) {
		Scheduler_bat = scheduler_bat;
	}



}
