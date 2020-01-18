package br.com.rpg.campaign.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.rpg.campaign.dao.DungeonMasterDao;
import br.com.rpg.campaign.util.JpaUtil;

/**
 * 
 * The Class Dungeon Master extends the class User and represents a dungeon
 * master. The dungeon master contains a name and is associated with a campaign.
 * 
 * @author jonas
 * @since 02/10/2019
 * @version 1.4
 *
 */

@Entity
public class DungeonMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@JoinColumn(unique = true)
	@OneToOne
	private User user;

	public DungeonMaster() {
	}

	public DungeonMaster(User newDM) {
		this.user = newDM;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public static List<DungeonMaster> getLista() {

		EntityManager em = new JpaUtil().getEntityManager();
		DungeonMasterDao dao = new DungeonMasterDao(em);
		return dao.getAllDungeonMasters();
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
