/**
 * 19 сент. 2015 г.
 */
package ru.davist.study.vaadin.domain;

/**
 * @author danil
 *
 */
public class CampaignCondition {
	
	private String condition;
	
	private String description;
	
	
	
	public CampaignCondition(String condition, String description) {
		super();
		this.condition = condition;
		this.description = description;
	}

	public CampaignCondition() {
		// TODO Auto-generated constructor stub
	}

	public String getCondition() {
		return condition;
	}
	
	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CampaignCondition [");
		if (condition != null) {
			builder.append("condition=");
			builder.append(condition);
			builder.append(", ");
		}
		if (description != null) {
			builder.append("description=");
			builder.append(description);
		}
		builder.append("]");
		return builder.toString();
	}

}
