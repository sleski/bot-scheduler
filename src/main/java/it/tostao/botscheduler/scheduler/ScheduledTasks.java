package it.tostao.botscheduler.scheduler;

import com.crozin.wykop.sdk.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Slawomir Leski on 13-03-2019.
 */
@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void printTime() {
		log.info("Time is {}", dateFormat.format(new Date()));
		Application application = new Application("wykop-bot", "xUg8fD0yHnaA0kpC4Flf");
	}

}
