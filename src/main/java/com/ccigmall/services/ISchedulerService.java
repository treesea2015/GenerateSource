package com.ccigmall.services;

import java.util.List;

import com.ccigmall.beans.Scheduler;

public interface ISchedulerService {
	
	public int insert(Scheduler Scheduler);
	public int selectMaxId();
	public void delete(int scheduler_id );
	public List<Scheduler> selectAll();
	public String findById(int scheduler_id);
}
