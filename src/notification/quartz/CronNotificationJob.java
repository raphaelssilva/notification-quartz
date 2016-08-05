package notification.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.ScheduleBuilder;

public abstract class CronNotificationJob implements NotificationJob{
	@Override
	public ScheduleBuilder getSchedule() {
		return CronScheduleBuilder.cronSchedule(this.getCron());
	}
	protected abstract String getCron();

}
