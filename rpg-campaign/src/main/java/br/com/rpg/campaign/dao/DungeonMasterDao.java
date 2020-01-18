package br.com.rpg.campaign.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.rpg.campaign.model.DungeonMaster;

public class DungeonMasterDao {
	
	EntityManager em;

	public DungeonMasterDao(EntityManager em) {
		this.em = em;
	}
	
	public List<DungeonMaster> getAllDungeonMasters() {
		
		em.getTransaction().begin();
		List<DungeonMaster> listDungeonMaster = em
				.createQuery("select object(o) from DungeonMaster as o", DungeonMaster.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listDungeonMaster;
		
	}
	
	public void createDungeonMaster(DungeonMaster dm) {
		
		em.getTransaction().begin();
		em.persist(dm);
		em.getTransaction().commit();
		em.close();
		
	}

}
