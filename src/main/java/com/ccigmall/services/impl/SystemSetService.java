package com.ccigmall.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ccigmall.beans.SystemSet;
import com.ccigmall.dao.SystemSetDao;
import com.ccigmall.services.ISystemSetService;

/**
 *<p> 
 * @author treesea888@icloud.com
 * @description SchedulerService 定时任务增删改
 */
@Service
public class SystemSetService implements ISystemSetService {
	
	private SystemSetDao systemSetDao;

	@Override
	public int insert(String restartBat) {
		return systemSetDao.insert(restartBat);
	}

	@Override
	public List<SystemSet> select() {
		return systemSetDao.select();
	}

	@Override
	public int update(int id, String restartBat) {
		return systemSetDao.update(id,restartBat);
	}
	

}
