package com.ccigmall.beans;

/**
 * 
 * @author treesea888@icloud.com
 * @description xml
 */

public class Xml {

	public String packageStr;
	public String className;
	public String description;
	public String ENTER = "\r\n ";
	/**
	 * @param packageStr 
	 * @param className 
	 * @param description 
	 */
	public Xml(String packageStr, String className, String description){
	 this.packageStr = packageStr;
	 this.className = className;
	 this.description = description;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer("");
		str.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"+ENTER);
		str.append("<!DOCTYPE suite SYSTEM \"http://beust.com/testng/testng-1.0.dtd\" >"+ENTER);
		str.append("<suite name=\""+description+"\" preserve-order=\"true\" parallel=\"tests\"	thread-count=\"1\">"+ENTER);
		str.append(ENTER);
		str.append("  <listeners>"+ENTER);
		str.append("  <listener class-name=\"com.ccigmall.auto.test.reporter.HTMLReporter\"/>"+ENTER);
		str.append("  </listeners>"+ENTER);
		str.append("  <test name=\""+description+"\" preserve-order=\"true\" thread-count=\"1\" verbose=\"1\">"+ENTER);
		str.append("	<classes>"+ENTER);
		str.append("		<class name=\""+packageStr+className+"\"/>"+ENTER);
		str.append("	</classes>"+ENTER);
		str.append("  </test>"+ENTER);
		str.append("</suite>"+ENTER);
		str.append(ENTER);
		return  str.toString();
	}
}
