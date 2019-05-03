package it.tostao.botscheduler.models;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Slawomir Leski on 18-03-2019.
 */
public class User {
	private long id;
	private String firstname;
	private String lastname;
	private int age;

	public User() {
		this.id = ThreadLocalRandom.current().nextLong(1, 99999999);
		this.firstname = RandomStringUtils.randomAlphabetic(10);
		this.lastname = RandomStringUtils.randomAlphabetic(10);
		this.age = ThreadLocalRandom.current().nextInt(0, 99);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", age=" + age +
				'}';
	}
}
