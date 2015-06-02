package com.ccigmall.controller;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;

import com.ccigmall.services.IGenerateCodeServices;

@Controller
@RequestMapping("/inputPageInfo")
public class BaseController {
	@Resource
	private IGenerateCodeServices iGenerateCodeServices;

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome() {
		return "pageInfo";
	}


	/**
	 * generate code ,controller 
	 * 备注：功能简单 未做异常处理
	 */
	@RequestMapping(value = "/generate", method = RequestMethod.POST)
	public @ResponseBody String  genetateCode( String packageStr, String importStr,	String className, String extendsStr, String author,	String description,String eName,String annotation,String locatorWay,String value ,String actType) throws IOException, ServletException {
		//数据
		String [] eName_data = eName.split(",");
		String [] annotation_data = annotation.split(",");
		String [] locatorWay_data = locatorWay.split(",");
		String [] value_data = value.split(",");
		String [] actType_data = actType.split(",");
		//webapps path
		String webroot = ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/").replace("GenerateCodes\\", "");
		//代码生成path
		String filePath = webroot+"codes"+File.separator+className;
		//代码生成
		iGenerateCodeServices.pro(filePath, packageStr, importStr, className, extendsStr, author, description, eName_data, annotation_data, locatorWay_data, value_data, actType_data);
		return className+".zip";
	}
	

}