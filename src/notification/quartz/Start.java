package notification.quartz;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import notification.quartz.jobs.TestJob;

public class Start {
	public static void main(String [] arg){
		init();
		Scheduler scheduler;
		try {
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			
			for(NotificationJob job: NotificationJobsStore.getJobs()){
				JobDetail jobDetail = newJob(job.getClass())
					      .withIdentity(job.getNome(), job.getGroup())
					      .build();
				Trigger trigger = newTrigger()
					      .withIdentity(job.getNome()+"Trigger", job.getGroup())
					      .startNow()
					      .withSchedule(job.getSchedule())
					      .build();
				 scheduler.scheduleJob(jobDetail, trigger);
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}	
	}
	
	private static void init(){
		NotificationJobsStore.addJob(new TestJob());
	}
}