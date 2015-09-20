/**
 * 20 сент. 2015 г.
 */
package ru.davist.study.vaadin.domain;

import java.util.Date;

/**
 * @author StarovoytovD
 *
 */
public class Client {
	
	private String name;
	
	private Integer age;
	
	private Date birthday;
	
	private Address address;
	
	public Client() {
	}
	
	public Client(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public Client(String name, Integer age, Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Client [");
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (age != null) {
			builder.append("age=");
			builder.append(age);
			builder.append(", ");
		}
		if (birthday != null) {
			builder.append("birthday=");
			builder.append(birthday);
			builder.append(", ");
		}
		if (address != null) {
			builder.append("address=");
			builder.append(address);
		}
		builder.append("]");
		return builder.toString();
	}

}
