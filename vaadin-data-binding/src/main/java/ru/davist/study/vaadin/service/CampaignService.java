/**
 * 19 сент. 2015 г.
 */
package ru.davist.study.vaadin.service;

import java.util.List;

import ru.davist.study.vaadin.domain.Campaign;

/**
 * @author danil
 *
 */
public interface CampaignService {
	
	public List<Campaign> getCampaigns();
	
	public Campaign getCampaign(String id);
	
	public void setCampaign(Campaign campaign);

}
