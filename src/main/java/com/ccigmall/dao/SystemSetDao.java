package com.ccigmall.dao;

import java.util.List;

import com.ccigmall.beans.SystemSet;

public interface SystemSetDao {
	public int insert(String restartBat);
    public int update(int systemset_id,String systemset_bat);
    public  List<SystemSet>  select();
	public void update(SystemSet systemSet);
}
