package notification.quartz;

import java.util.ArrayList;
import java.util.List;

public class NotificationJobsStore {
	private static List<NotificationJob> jobs = new ArrayList<NotificationJob>();
	
	public static void addJob(NotificationJob job){
		jobs.add(job);
	}
	
	public static List<NotificationJob> getJobs(){
		return jobs;
	}
	
	
}
