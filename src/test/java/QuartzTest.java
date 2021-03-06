/**
 * @Description: 
 *
 * @Title: QuartzTest.java
 * @Package com.joyce.quartz.main
 * @Copyright: Copyright (c) 2014
 *
 * @author Comsys-LZP
 * @date 2014-6-26 下午03:35:05
 * @version V2.0
 */


import java.lang.reflect.Field;

/**
 * @Description: 测试类
 *
 * @ClassName: QuartzTest
 * @Copyright: Copyright (c) 2014
 *
 * @author Comsys-LZP
 * @date 2014-6-26 下午03:35:05
 * @version V2.0
 */
public class QuartzTest {
	public static void main(String[] args) {
		try {
			String [] command = {"pause"};
			String job_name = "动态任务调度";
			System.out.println("【系统启动】开始(每1秒输出一次)...");  
			QuartzJob q  = new QuartzJob();
			Field f=QuartzJob.class.getDeclaredField("command");
			System.out.println(f.get(q));
			f.set(q, "pause");
			System.out.println(f.get(q));
			QuartzManager.addJob(job_name, QuartzJob.class, "0/1 * * * * ?",command);  
			
			
			
			Thread.sleep(5000);  
			System.out.println("【修改时间】开始(每2秒输出一次)...");  
			QuartzManager.modifyJobTime(job_name, "10/2 * * * * ?",command);  
			Thread.sleep(6000);  
			System.out.println("【移除定时】开始...");  
			QuartzManager.removeJob(job_name);  
			System.out.println("【移除定时】成功");  
			
			System.out.println("【再次添加定时任务】开始(每10秒输出一次)...");  
			QuartzManager.addJob(job_name, QuartzJob.class, "*/10 * * * * ?",command);  
			Thread.sleep(60000);  
			System.out.println("【移除定时】开始...");  
			QuartzManager.removeJob(job_name);  
			System.out.println("【移除定时】成功");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
