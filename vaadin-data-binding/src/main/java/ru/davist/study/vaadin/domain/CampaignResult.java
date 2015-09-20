/**
 * 19 сент. 2015 г.
 */
package ru.davist.study.vaadin.domain;

/**
 * @author danil
 *
 */
public class CampaignResult {

	private String type;
	
	private Double value;
	
	

	public CampaignResult(String type, Double value) {
		super();
		this.type = type;
		this.value = value;
	}

	public CampaignResult() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CampaignResult [");
		if (type != null) {
			builder.append("type=");
			builder.append(type);
			builder.append(", ");
		}
		if (value != null) {
			builder.append("value=");
			builder.append(value);
		}
		builder.append("]");
		return builder.toString();
	}
	
	
}
