package com.ccigmall.controller;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.ccigmall.beans.SystemSet;
import com.ccigmall.dao.SystemSetDao;
import com.ccigmall.services.IGenerateCodeServices;

/**
 * @Description: 设置，中间件的重启设置
 * @author treesea888@icloud.com
 */
@Controller
@RequestMapping(value = "/systemSet")
public class SystemSetController {
	@Resource
	private SystemSetDao systemSetDao;
	@Resource
	private  IGenerateCodeServices generateCodeServices;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST )
	public  String welcome(String restartBat) {
		systemSetDao.insert(restartBat);
		return "redirect:";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public  String setTime(int systemset_id,String systemset_bat){
		SystemSet SystemSet = new SystemSet();
		SystemSet.setSystemset_bat(systemset_bat);
		SystemSet.setSystemset_id(systemset_id);
		systemSetDao.update(SystemSet);
		return "redirect:/scheduler";
	}
}
