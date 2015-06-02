/**
 * @Description: 
 *
 * @Title: QuartzJob.java
 * @Package com.joyce.quartz
 * @Copyright: Copyright (c) 2014
 *
 * @author Comsys-LZP
 * @date 2014-6-26 下午03:37:11
 * @version V2.0
 */


import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.ccigmall.utils.RuntimeExecCommand;

/**
 * @Description: 任务执行类
 *
 * @ClassName: QuartzJob
 * @Copyright: Copyright (c) 2014
 *
 * @author Comsys-LZP
 * @date 2014-6-26 下午03:37:11
 * @version V2.0
 */
public class QuartzJob implements Job {
	
	private Assert aAssert;
	
	public void  assertFail(){
		aAssert.fail();
	}


	@Override
	public void execute(JobExecutionContext x) throws JobExecutionException {
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ "★★★★★★★★★★★"+"定时任务开始..");  
/*		new RuntimeExecCommand().execCommandFile();  
*/
	}
}
