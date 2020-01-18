package br.com.rpg.campaign.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.rpg.campaign.model.PlayableCharacter;
import br.com.rpg.campaign.model.Player;
import br.com.rpg.campaign.model.User;

public class PlayerDao {

	EntityManager em;

	public PlayerDao(EntityManager em) {
		this.em = em;
	}
	
	public List<Player> getAllPlayers(){
		
		em.getTransaction().begin();
		List<Player> listPlayer = em.createQuery("select object(o) from Player as o", Player.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listPlayer;
		
	}
	
	public List<Player> getAllPlayersByUser(User user) {
		
		em.getTransaction().begin();
		String jpql = "select object(o) from Player as o";
		TypedQuery<Player> query = em.createQuery(jpql, Player.class);
		List<Player> listPlayer = query.getResultList();
		List<Player> listUserPlayers = new ArrayList<Player>();
		for (Player player : listPlayer) {
			if (player.getUser().getId() == user.getId()) {
				listUserPlayers.add(player);
			}
		}
		em.close();
		return listUserPlayers;
		
	}
	
	public void createPlayer(Player player, PlayableCharacter character) {
		
		em.getTransaction().begin();
		em.persist(player);
		em.persist(character);
		em.getTransaction().commit();
		em.close();
		
	}

}
