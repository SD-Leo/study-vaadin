/**
 * 19 сент. 2015 г.
 */
package ru.davist.study.vaadin.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author danil
 *
 */
public class Campaign {
	
	private String id;
	
	private String name;

	private Date start;
	
	private Date end;
	
	private List<CampaignCondition> conditions;
	
	private CampaignResult result;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public CampaignResult getResult() {
		return result;
	}

	public void setResult(CampaignResult result) {
		this.result = result;
	}
	
	public List<CampaignCondition> getConditions() {
		return conditions;
	}
	
	public void setConditions(List<CampaignCondition> conditions) {
		this.conditions = conditions;
	}
	
	public void addConditions(CampaignCondition condition) {
		if (conditions == null) {
			conditions = new ArrayList<>();
		}
		conditions.add(condition);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Campaign [");
		if (id != null) {
			builder.append("id=");
			builder.append(id);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		if (start != null) {
			builder.append("start=");
			builder.append(start);
			builder.append(", ");
		}
		if (end != null) {
			builder.append("end=");
			builder.append(end);
			builder.append(", ");
		}
		if (conditions != null) {
			builder.append("conditions=");
			builder.append(conditions);
			builder.append(", ");
		}
		if (result != null) {
			builder.append("result=");
			builder.append(result);
		}
		builder.append("]");
		return builder.toString();
	}


	
	

}
