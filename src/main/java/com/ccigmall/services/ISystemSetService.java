package com.ccigmall.services;

import java.util.List;

import com.ccigmall.beans.SystemSet;

public interface ISystemSetService {
	
	public int insert(String restartBat);
    public int update(int id,String restartBat);
    public List<SystemSet> select();
}
