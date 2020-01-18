package br.com.rpg.campaign.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.rpg.campaign.dao.PlayerDao;
import br.com.rpg.campaign.util.JpaUtil;

/**
 * 
 * The Class Player extends the class User and represents a player. The player
 * have a name and a character. The player is associated with a campaign.
 * 
 * @author jonas
 * @since 02/10/2019
 * @version 1.4
 *
 */

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	private User user;

	public Player() {
	};

	public Player(User loggedUser) {
		this.user = loggedUser;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static List<Player> getLista() {

		EntityManager em = new JpaUtil().getEntityManager();
		PlayerDao dao = new PlayerDao(em);
		return dao.getAllPlayers();
	}

	public static List<Player> getUserPlayers(User user) {

		EntityManager em = new JpaUtil().getEntityManager();
		PlayerDao dao = new PlayerDao(em);
		return dao.getAllPlayersByUser(user);
		
	}

	public User getUser() {
		return user;
	}

}