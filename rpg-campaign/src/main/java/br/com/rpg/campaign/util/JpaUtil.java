package br.com.rpg.campaign.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("rpg-campaign");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}
