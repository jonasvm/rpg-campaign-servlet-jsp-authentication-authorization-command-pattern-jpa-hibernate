package br.com.rpg.campaign.model;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.rpg.campaign.dao.CampaignDao;
import br.com.rpg.campaign.util.JpaUtil;

/**
 * 
 * The Class Campaign represents a campaign. The campaign contains a name, a
 * dungeon master, a list of players and a list of non playable characters. The
 * campaign is the association of all elements necessary to start a game. The
 * responsibility of this class is to hold the updated list of characters and
 * non playable characters, that are the references to update the characters and
 * non playable characters statistics.
 * 
 * @author jonas
 * @version 1.4
 * @since 02/10/2019
 *
 */

@Entity
public class Campaign {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String campaignName;
	@ManyToOne
	private DungeonMaster dungeonMaster;
//	private List<NonPlayableCharacter> nonPlayableCharacterList = new ArrayList<NonPlayableCharacter>();
//	private List<Player> playerList = new ArrayList<Player>();
	private Date creationDate;

	public Campaign() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCampaignName() {
		return campaignName;
	}

	public void setCampaignName(String campaignName) {
		this.campaignName = campaignName;
	}

	public DungeonMaster getDungeonMaster() {
		return dungeonMaster;
	}

	public void setDungeonMaster(DungeonMaster dungeonMaster) {
		this.dungeonMaster = dungeonMaster;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Campaign(DungeonMaster dungeonMaster, String campaignName) {
		this.campaignName = campaignName;
		this.dungeonMaster = dungeonMaster;
		this.creationDate = new Date();
	}

	public static List<Campaign> getLista() {

		EntityManager em = new JpaUtil().getEntityManager();
		CampaignDao dao = new CampaignDao(em);
		return dao.getAllCampaigns();
		
	}

	public boolean removeCampaign(Integer id) {
		Iterator<Campaign> it = getLista().iterator();

		while (it.hasNext()) {
			Campaign campaign = it.next();
			if (campaign.getId() == id) {
				it.remove();
				return true;
			}
		}
		return false;
	}

	public Campaign searchCampaignById(Integer id) {

		for (Campaign campaign : getLista()) {
			if (campaign.getId() == id) {
				return campaign;
			}
		}
		return null;
	}

}
