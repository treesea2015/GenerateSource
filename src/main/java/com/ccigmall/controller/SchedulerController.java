package com.ccigmall.controller;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ContextLoader;

import com.ccigmall.beans.Scheduler;
import com.ccigmall.beans.SystemSet;
import com.ccigmall.dao.SystemSetDao;
import com.ccigmall.services.impl.SchedulerService;
import com.ccigmall.utils.RuntimeExecCommand;

/**
 * @Description: 定时任务管理类
 * @author treesea888@icloud.com
 */
@Controller
@RequestMapping(value = "/scheduler")
public class SchedulerController {

	@Resource(name="iSchedulerService")
	private SchedulerService schedulerService;
	@Resource
	private SystemSetDao systemSetDao;
	
	@RequestMapping(value = "", method = RequestMethod.GET )
	public  String welcome(ModelMap model) {
		List<Scheduler> schedulerList = schedulerService.selectAll();
		List<SystemSet> systemSetlist = systemSetDao.select();
		model.addAttribute("schedulerList", schedulerList);
		if(systemSetlist.size()>0){
			model.addAttribute("systemset_id", systemSetlist.get(0).getSystemset_id());
			model.addAttribute("restartBat", systemSetlist.get(0).getSystemset_bat());
		}else{
			model.addAttribute("systemset_id", "");

			model.addAttribute("restartBat", "");
		}

		return "Scheduler";
	}
	/**
	 * 添加定时任务
	 * @param jobName
	 * @param bat
	 * @param startTime
	 * @param scheduler
	 * @return
	 */
	@RequestMapping(value = "/setTime", method = RequestMethod.POST)
	public  String setTime(String jobName,String bat,String startTime,Scheduler scheduler){
		Scheduler aScheduler = new Scheduler();
		aScheduler.setScheduler_id(schedulerService.selectMaxId());
		aScheduler.setScheduler_name(jobName);
		aScheduler.setScheduler_bat(bat);
		aScheduler.setStartTime(startTime);
		schedulerService.insert(aScheduler);
		return "redirect:";
	}
	/*
	 * 删除定时任务
	 */
	@RequestMapping(value = "/delScheduler", method = RequestMethod.POST)
	public String delJob(int schedulerId){
		schedulerService.delete(schedulerId);
		return "redirect:";
	}
	/**
	 * 重启生效
	 * @return
	 */
	@RequestMapping(value = "/restart")
	public String reStart(){
		 RuntimeExecCommand runtimeExecCommand =new RuntimeExecCommand();
		List<SystemSet> systemSetlist = systemSetDao.select();
		String content  = systemSetlist.get(0).getSystemset_bat();
		String webroot = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/")+"restart.bat";
		runtimeExecCommand.write(webroot, content);
		runtimeExecCommand.execCommandFile(webroot);
		return "redirect:";
	}
	@RequestMapping(value = "/run")
	public String run(int scheduler_id){
		RuntimeExecCommand runtimeExecCommand =new RuntimeExecCommand();
		String content = schedulerService.findById(scheduler_id);
		String webroot = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/")+"tmpRun.bat";
		runtimeExecCommand.write(webroot, content);
		runtimeExecCommand.execCommandFile(webroot);
		return "redirect:";
	}
	

}
