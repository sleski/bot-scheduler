package it.tostao.botscheduler.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Slawomir Leski on 13-03-2019.
 */
@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 5000)
	public void printTime() throws URISyntaxException{
		log.info("Time is {}", dateFormat.format(new Date()));


//		String url = "https://localhost:8080/user/add";

		/* All codes is just for check */
//		User user = new User();
//		restTemplateBuilder.build().postForObject(url, user, User.class);



//		String url = "http://localhost:8080/users/counter";
//		URI uri = new URI(url);
//		ResponseEntity<String> response = restTemplateBuilder.build().getForEntity(uri, String.class);
//		log.info("Response code is = {}", response.getStatusCode());

	}

}
