package com.ccigmall.beans;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author treesea888@icloud.com
 * @description action
 */

public class Step {

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
	public Step(String packageStr,String importStr, String className, String extendsStr, String author, String description, String[] eName, String[] annotation,String[] actType){
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
		String Lower = className.substring(0, 1).toLowerCase()+className.substring(1)+"Act";
		String Act = Lower+".";
		str.append("package "+packageStr+ENTER);
		str.append("import org.openqa.selenium.support.*;"+ENTER);
		str.append("import org.openqa.selenium.*;"+ENTER);
		str.append("import java.util.*;"+ENTER);
		str.append("import org.slf4j.*;"+ENTER);
		str.append("import org.testng.annotations*;"+ENTER);
		str.append("import "+importStr+"Act;"+ENTER);
		str.append("/**"+ENTER);
		str.append("*@author "+author+ENTER);
		str.append("*@description Action "+description+ENTER);
		str.append("*@Date "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+ENTER);
		str.append("*/"+ENTER);
		str.append("public class "+className+"Step"+("".equals(extendsStr)? "":" extends "+extendsStr)+"{"+ENTER);
		str.append("  /**"+ENTER);
		str.append("  *Act "+ENTER);
		str.append("  */"+ENTER);
		str.append("  private "+className+"Act "+Lower+";"+ENTER);
		str.append("  /**"+ENTER);
		str.append("  *slf4j "+ENTER);
		str.append("  */"+ENTER);
		str.append("  private final static Logger logger = LoggerFactory.getLogger("+className+"Step.class);"+ENTER);
		str.append(ENTER);
		str.append("  @Test(description=\""+description+"\")"+ENTER);
		str.append("  @Parameters({ \"data0\", \"data1\"})"+ENTER);
		str.append("  public void "+className+"Step"+"(String data0,String data1) {"+ENTER);
		str.append("  try{"+ENTER);
		str.append("	"+Lower+" = new "+className+"Act(driver);"+ENTER);
		for(int i=0; i<actType.length;i++){
			Upper = eName[i].substring(0, 1).toUpperCase()+ eName[i].substring(1);
			if("input".equals(actType[i]))
			{
				str.append("   //input"+annotation[i]+ENTER);
				str.append("   "+Act+"input"+Upper+"(input_text);"+ENTER);
			}else if("click".equals(actType[i])){
				str.append("   //click"+annotation[i]+ENTER);
				str.append("   "+Act+"click"+Upper+"();"+ENTER);
			}else if("select".equals(actType[i])){
				str.append("   //select"+annotation[i]+ENTER);
				str.append("   "+Act+"select"+Upper+"(select_text);"+ENTER);
			}else{
				str.append("   //自己需要的步骤，"+ENTER);
				str.append("   //自己需要的步骤，"+ENTER);
			}
		}
		str.append("   } catch (Exception e) {"+ENTER);
		str.append("     logger.error(\""+description+"  failed \", e);"+ENTER);
		str.append("     "+Act+"failScreenShot(getClass().getName());"+ENTER);
		str.append("     throw new Exception(\""+description+" failed  >>\" e.getMessage(), e); "+ENTER);
		str.append("   }"+ENTER);
		str.append("  }"+ENTER);
		str.append("}"+ENTER);
		return  str.toString();
	}
}
