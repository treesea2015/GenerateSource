package com.ccigmall.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author treesea888@icloud.com
 * @description action
 */

public class Action {

	public String packageStr;
	public String importStr;
	public String className;
	public String extendsStr;
	public String author;
	public String description;
	public String[] eName;
	public String[] annotation;
	public String[] actType;
	public String ENTER = "\r\n ";
	/**
	 * init
	 * @param packageStr 
	 * @param className 
	 * @param extendsStr 
	 * @param author 
	 * @param description 
	 * @param eName 
	 * @param annotation 
	 * @param locatorWay 
	 * @param value 
	 */
	public Action(String packageStr,String importStr, String className, String extendsStr, String author, String description, String[] eName, String[] annotation,String[] actType){
	 this.packageStr = packageStr;
	 this.importStr = importStr;
	 this.className = className;
	 this.extendsStr = extendsStr;
	 this.author = author;
	 this.description = description;
	 this.eName = eName;
	 this.annotation = annotation;
	 this.actType = actType;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer("");
		String Upper;
		String getter;
		String Lower = className.substring(0, 1).toLowerCase()+className.substring(1)+"Page";
		str.append("package "+packageStr+ENTER);
		str.append("import org.openqa.selenium.support.*;"+ENTER);
		str.append("import org.openqa.selenium.*;"+ENTER);
		str.append("import java.util.*;"+ENTER);
		str.append("import org.slf4j.*;"+ENTER);
		str.append("import "+importStr+"Act;"+ENTER);
		str.append("/**"+ENTER);
		str.append("*@author "+author+ENTER);
		str.append("*@description Action "+description+ENTER);
		str.append("*@Date "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+ENTER);
		str.append("*/"+ENTER);
		str.append("public class "+className+"Act"+("".equals(extendsStr)? "":"  extends   "+extendsStr)+"{"+ENTER);
		str.append("  /**"+ENTER);
		str.append("  *page "+ENTER);
		str.append("  */"+ENTER);
		str.append("  private "+className+"Page "+Lower+";"+ENTER);
		str.append("  /**"+ENTER);
		str.append("  *slf4j "+ENTER);
		str.append("  */"+ENTER);
		str.append("  private final static Logger logger = LoggerFactory.getLogger("+className+"Act.class);"+ENTER);
		str.append("  /**"+ENTER);
		str.append("  *@param  driver "+ENTER);
		str.append("  */"+ENTER);
		str.append("  public "+className+"Act"+"(WebDriver driver) {"+ENTER);
		str.append("	super(driver);"+ENTER);
		str.append("	"+Lower+" = new  "+className+"Page();"+ENTER);
		str.append("   }"+ENTER);
		//findBy(id="")
		for(int i=0; i<actType.length;i++){
			Upper = eName[i].substring(0, 1).toUpperCase()+ eName[i].substring(1);
			if("input".equals(actType[i]))
			{
				str.append("  /**"+ENTER);
				str.append("  *input"+annotation[i]+ENTER);
				str.append("  */"+ENTER);
				str.append("  public void input"+Upper+"(String text){"+ENTER);
				str.append("  	logger.info(\"input "+annotation[i]+":{}\",text);"+ENTER);
				getter = "get"+Upper+"(),text);";
				str.append("  	type("+Lower+"."+getter+ENTER);
				str.append("   }"+ENTER);
			}else if("click".equals(actType[i])){
				str.append("  /**"+ENTER);
				str.append("  *click"+annotation[i]+ENTER);
				str.append("  */"+ENTER);
				str.append("  public void click"+Upper+"(){"+ENTER);
				str.append("  	logger.info(\"click "+annotation[i]+"\");"+ENTER);
				getter = "get"+Upper+"());";
				str.append("  	click("+Lower+"."+getter+ENTER);
				str.append("   }"+ENTER);
			}else if("select".equals(actType[i])){
				str.append("  /**"+ENTER);
				str.append("  *select"+annotation[i]+ENTER);
				str.append("  */"+ENTER);
				str.append("  public void select"+Upper+"(String text){"+ENTER);
				str.append("  	logger.info(\"select "+annotation[i]+":{}\",text);"+ENTER);
				getter = "get"+Upper+"(),text);";
				str.append("  	select("+Lower+"."+getter+ENTER);
				str.append("   }"+ENTER);
			}else{
				str.append("  /**"+ENTER);
				str.append("  *DIY"+annotation[i]+ENTER);
				str.append("  */"+ENTER);
				str.append("  public void DIY"+Upper+"(){"+ENTER);
				str.append("  	logger.info(\"write sth you like "+annotation[i]+"\");"+ENTER);
				getter = "get"+Upper+"(),text);";
				str.append("  	//write sth you like;"+ENTER);
				str.append("   }"+ENTER);
			}
			
		}
		str.append("}");
		return  str.toString();
	
	}


}
