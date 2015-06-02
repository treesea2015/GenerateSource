package com.ccigmall.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ccigmall.beans.Scheduler;
import com.ccigmall.dao.SchedulerDao;
import com.ccigmall.services.ISchedulerService;

/**
 *<p> 
 * @author treesea888@icloud.com
 * @description SchedulerService 定时任务增删改
 */
@Service
public class SchedulerService implements ISchedulerService {
	
	private SchedulerDao schedulerDao;
	public SchedulerDao getSchedulerDao() {
		return schedulerDao;
	}
	public void setSchedulerDao(SchedulerDao schedulerDao) {
		this.schedulerDao = schedulerDao;
	}
	
	@Override
	public int insert(Scheduler Scheduler) {
		return schedulerDao.insert(Scheduler);
	}
	@Override
	public List<Scheduler> selectAll() {
		return schedulerDao.selectAll();
	}
	@Override
	public int selectMaxId() {
		return schedulerDao.selectMaxId();
	}

	@Override
	public void delete(int scheduler_id) {
		 schedulerDao.delete(scheduler_id);
		
	}
	@Override
	public String findById(int scheduler_id) {
		return schedulerDao.findById(scheduler_id);
		
	}

}
