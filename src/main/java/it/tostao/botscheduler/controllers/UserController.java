package it.tostao.botscheduler.controllers;

import it.tostao.botscheduler.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Slawomir Leski on 18-03-2019.
 */
@RequestMapping("/user")
@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<User> add(@RequestBody User user) {
		log.info("User has been created, {}", user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/counter", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Integer> count() {
		int counter = ThreadLocalRandom.current().nextInt(0, 99);
		log.info("Now we have {} users.", counter);
		return new ResponseEntity<>(counter, HttpStatus.OK);
	}
}
