package com.ccigmall.dao;

import java.util.List;



import com.ccigmall.beans.Scheduler;

public interface SchedulerDao {
	public int insert(Scheduler scheduler);
    
    public int update(Scheduler schedule);
   
    public int delete(int schedule_id);
    
    public int delete(String schedule_name);

   
    public List<Scheduler> selectAll();
    
    public int selectMaxId();

    public int countAll();
   
    public Scheduler findScheduleName(String schedule_name);

	public String findById(int scheduler_id);

}
