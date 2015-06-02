package com.ccigmall.beans;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * 
 * @author treesea888@icloud.com
 * @description page
 */

public class Page {

	public String packageStr;
	//public String importStr;
	public String className;
	public String extendsStr;
	public String author;
	public String description;
	public String[] eName;
	public String[] annotation;
	public String[] locatorWay;
	public String[] value;
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
	public Page(String packageStr, String className, String extendsStr, String author, String description, String[] eName, String[] annotation, String[] locatorWay, String[] value){
	 this.packageStr = packageStr;
	 this.className = className;
	 this.extendsStr = extendsStr;
	 this.author = author;
	 this.description = description;
	 this.eName = eName;
	 this.annotation = annotation;
	 this.locatorWay = locatorWay;
	 this.value = value;
	}
	
	
	
	public String toStringAll() {
		return "Page [packageStr=" + packageStr 
				+ ", className=" + className + ", extendsStr=" + extendsStr
				+ ", author=" + author + ", description=" + description
				+ ", eName=" + Arrays.toString(eName) + ", annotation="
				+ Arrays.toString(annotation) + ", locatorWay="
				+ Arrays.toString(locatorWay) + ", value="
				+ Arrays.toString(value) + ", ENTER=" + ENTER + "]";
	}

	public String toString() {
		StringBuffer str = new StringBuffer("");
		String Upper;
		str.append("package "+packageStr+ENTER);
		str.append("import org.openqa.selenium.support.*;"+ENTER);
		str.append("import org.openqa.selenium.*;"+ENTER);
		str.append("import java.util.*;"+ENTER);
		str.append("/**"+ENTER);
		str.append("*@author "+author+ENTER);
		str.append("*@description "+description+ENTER);
		str.append("*@Date "+new SimpleDateFormat("yyyy-MM-dd").format(new Date())+ENTER);
		str.append("*/"+ENTER);
		str.append("public class "+className+"Page"+("".equals(extendsStr)? "":"  extends   "+extendsStr)+"{"+ENTER);
		str.append("public "+className+"Page"+"(WebDriver driver) {"+ENTER);
		str.append("	super(driver);"+ENTER);
		str.append("    }"+ENTER);
		//findBy(id="")
		for(int i=0; i<eName.length;i++){
			str.append("       /**"+ENTER);
			str.append("       /*"+annotation[i]+ENTER);
			str.append("       */"+ENTER);
			str.append("       @FindBy("+locatorWay[i]+"=\""+value[i]+"\")"+ENTER);
			str.append("       private WebElement  "+eName[i]+";"+ENTER);

		}
		//get sth(){}
		for(int i=0; i<eName.length;i++){
			Upper = eName[i].substring(0,1).toUpperCase()+eName[i].substring(1);
			str.append("       /**"+ENTER);
			str.append("       /* @return "+annotation[i]+ENTER);
			str.append("       */"+ENTER);
			str.append("       public WebElement get"+Upper+"(){"+ENTER);
			str.append("            return "+eName[i]+";"+ENTER);
			str.append("       }"+ENTER);
			}
		str.append("}");
		return  str.toString();
	
	}


}
