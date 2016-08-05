package notification.quartz;

import org.quartz.Job;
import org.quartz.ScheduleBuilder;
import org.quartz.Trigger;

public interface NotificationJob extends Job{
	 ScheduleBuilder<Trigger> getSchedule();
	 String getGroup();
	 String getNome();	
}
