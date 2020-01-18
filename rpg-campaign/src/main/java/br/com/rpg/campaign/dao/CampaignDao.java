package br.com.rpg.campaign.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.rpg.campaign.model.Campaign;
import br.com.rpg.campaign.model.DungeonMaster;

public class CampaignDao {

	EntityManager em;

	public CampaignDao(EntityManager em) {
		this.em = em;
	}

	public List<Campaign> getAllCampaigns() {

		em.getTransaction().begin();
		List<Campaign> listCampaign = em.createQuery("select object(o) from Campaign as o", Campaign.class)
				.getResultList();
		em.getTransaction().commit();
		em.close();
		return listCampaign;

	}
	
	public void createCampaign(Campaign campaign) {
		
		em.getTransaction().begin();
		em.persist(campaign);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public void removeCampaignById(int id) {
		
		em.getTransaction().begin();
		Campaign campaign = em.find(Campaign.class, id);
		em.remove(campaign);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public Campaign editCampaignByCampaignIdAndDungeonMasterId(int campaignId, int dmId, String campaignName) {
		
		em.getTransaction().begin();
		Campaign campaign = em.find(Campaign.class, campaignId);
		DungeonMaster dungeonMaster = em.find(DungeonMaster.class, dmId);
		campaign.setCampaignName(campaignName);
		campaign.setDungeonMaster(dungeonMaster);
		em.merge(campaign);
		em.getTransaction().commit();
		em.close();
		
		return campaign;
		
	}

}
