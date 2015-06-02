import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ccigmall.beans.Scheduler;
import com.ccigmall.services.impl.SchedulerService;


public class testMybaits {
	private SchedulerService schedulerService;
    
    @Before
    public void before(){                                                                   
        ApplicationContext context = new  ClassPathXmlApplicationContext(new String[]{"classpath:mvc-dispatcher-servlet.xml"});
        
        schedulerService = (SchedulerService) context.getBean("iSchedulerService");
    }
     
    @Test
    public void insert(){
    	Scheduler scheduler = new Scheduler();
    	scheduler.setScheduler_id(001);
    	scheduler.setScheduler_bat("cd");
    	scheduler.setScheduler_name("name");
    	scheduler.setStartTime("2014-01-01 06:06:06");

        System.out.println(schedulerService.insert(scheduler));
    }

}
