/**
 * 20 сент. 2015 г.
 */
package ru.davist.study.vaadin.domain;

/**
 * @author StarovoytovD
 *
 */
public class Address {
	
	private String street;
	
	private String number;
	
	public Address() {
	}
	
	public Address(String street, String number) {
		this.street = street;
		this.number = number;
	}
	
	public String getStreet() {
		return street;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [");
		if (street != null) {
			builder.append("street=");
			builder.append(street);
			builder.append(", ");
		}
		if (number != null) {
			builder.append("number=");
			builder.append(number);
		}
		builder.append("]");
		return builder.toString();
	}

}
