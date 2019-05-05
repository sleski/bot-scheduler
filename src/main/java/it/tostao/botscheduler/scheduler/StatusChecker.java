package it.tostao.botscheduler.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by Slawomir Leski on 05-05-2019.
 */
@Component
public class StatusChecker {

	private static final Logger log = LoggerFactory.getLogger(StatusChecker.class);

	@Value("${heroku.apps}")
	private String apps;

	private final String APP_PLACEHOLDER = "APP_NAME";
	private final String HEROKU_APP_PATTERN = "https://" + APP_PLACEHOLDER + ".herokuapp.com/";

	@Scheduled(cron="0 0/20 * * * ?")
	public void checkStatusApps() {

		RestTemplateBuilder templateBuilder = new RestTemplateBuilder();
		RestTemplate template = templateBuilder.build();

		log.info("Job found these apps: {}", apps);
		Arrays.asList(apps.split(",")).forEach(appName -> {
			String appUrl = HEROKU_APP_PATTERN.replace(APP_PLACEHOLDER, appName);
			try {
				ResponseEntity<String> response = template.getForEntity(appUrl, String.class);
				log.info("Called Application {} with url {}, response = {}.", appName, appUrl, response.getStatusCode());
			} catch (Exception e) {
				log.error("Problem occured for {} url: {}", appName, appUrl, e);
			}
		});
	}
}
