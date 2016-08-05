package notification.quartz.jobs;

import java.util.Date;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import notification.quartz.CronNotificationJob;

public class TestJob extends CronNotificationJob{
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println(new Date());				
	}
	
	@Override
	public String getNome() {
		return "TesteQuartz";
	}
	
	@Override
	public String getGroup() {
		return "TesteQuartzGroup";
	}
	@Override
	protected String getCron() {
		return "0/5 * * * * ?";
	}
}
