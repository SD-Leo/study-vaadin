/**
 * 19 сент. 2015 г.
 */
package ru.davist.study.vaadin.service;

import javax.annotation.PostConstruct;

import com.vaadin.spring.annotation.SpringComponent;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ru.davist.study.vaadin.domain.Campaign;
import ru.davist.study.vaadin.domain.CampaignCondition;
import ru.davist.study.vaadin.domain.CampaignResult;

/**
 * @author danil
 *
 */
@SpringComponent
public class CampaignServiceImpl implements CampaignService {
	
	private List<Campaign> campaigns;
	
	@Override
	public List<Campaign> getCampaigns() {
		if (campaigns != null) {
			return campaigns;
		}
		return new ArrayList<>();
	}
	
	@Override
	public Campaign getCampaign(String id) {
		if (campaigns != null) {
			for (Campaign campaign : campaigns) {
				if (campaign.getId().equals(id)) {
					return campaign;
				}
			}
		}
		return null;
	}
	
	@Override
	public void setCampaign(Campaign campaign) {
		// TODO Auto-generated method stub
		
	}
	
	@PostConstruct
	public void init() {
		campaigns = new ArrayList<>();
		Campaign campaign = new Campaign();
		campaign.setId("111");
		campaign.setName("Super campaign");
		campaign.setStart(new Date());
		Calendar cal = Calendar.getInstance();
		cal.set(2015, 9, 17, 10, 0, 0);
		campaign.setEnd(cal.getTime());
		campaign.addConditions(new CampaignCondition("a>1", "A greater than 1"));
		campaign.addConditions(new CampaignCondition("1+2=3", "One plus Two equal Three"));
		campaign.setResult(new CampaignResult("percent", 50.0));
		campaigns.add(campaign);
		
		campaign = new Campaign();
		campaign.setId("222");
		campaign.setName("One more campaign");
		campaign.addConditions(new CampaignCondition("123123", "jfaisuehf"));
		campaign.setResult(new CampaignResult("sum", 1000.0));
		
		campaigns.add(campaign);
		
	}
	
}
