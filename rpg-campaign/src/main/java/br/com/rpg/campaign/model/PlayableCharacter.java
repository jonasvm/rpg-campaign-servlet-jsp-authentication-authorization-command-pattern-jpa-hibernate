package br.com.rpg.campaign.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.rpg.campaign.dao.PlayableCharacterDao;
import br.com.rpg.campaign.util.JpaUtil;

/**
 * 
 * The Abstract Class Character represents a generic form of a 3D&T - Defensores
 * de Toquio 3 Edi��o Alpha's character.
 * 
 * Any character have the following attributes: name, points, strength,
 * dexterity, endurance, armor, fire power, level, hit points, magic points,
 * advantages, disadvantages, damage types, known spells, money, items and a
 * background history.
 * 
 * A character might be of two types: Playable Character or Non Playable
 * Character. The Playable character is the one owned by a Player. The Non
 * Playable Character is owned by a campaign and differently of the Playable
 * one, it didn't have experience points.
 * 
 * The level attribute is optional in this system, so it is required in
 * character creation but it is not mandatory.
 * 
 * @author jonas
 * @version 1.4
 * @since 02/10/2019
 *
 */

@Entity
public class PlayableCharacter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private int points;
	private int strength;
	private int dexterity;
	private int endurance;
	private int armor;
	private int firePower;
	private int level;
	private int hitPoints;
	private int magicPoints;
//	private Set<String> advantages = new HashSet<>();
//	private Set<String> disadvantages = new HashSet<>();
//	private Set<String> damageTypes = new HashSet<>();
//	private Set<String> knownSpells = new HashSet<>();
//	private Set<String> moneyAndItems = new HashSet<>();
	@JoinColumn(unique = true)
	@OneToOne
	private Player player;

	public PlayableCharacter() {
	}

	public PlayableCharacter(String name, int points, int strength, int dexterity, int endurance, int armor,
			int firePower, int level, int hitPoints, int magicPoints, Player player) {

		this.name = name;
		this.points = points;
		this.strength = strength;
		this.dexterity = dexterity;
		this.endurance = endurance;
		this.armor = armor;
		this.firePower = firePower;
		this.level = level;
		this.hitPoints = hitPoints;
		this.magicPoints = magicPoints;
		this.player = player;
//		this.advantages = advantages;
//		this.disadvantages = disadvantages;
//		this.damageTypes = damageTypes;
//		this.knownSpells = knownSpells;
//		this.moneyAndItems = moneyAndItems;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getDexterity() {
		return dexterity;
	}

	public void setDexterity(int dexterity) {
		this.dexterity = dexterity;
	}

	public int getEndurance() {
		return endurance;
	}

	public void setEndurance(int endurance) {
		this.endurance = endurance;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public int getFirePower() {
		return firePower;
	}

	public void setFirePower(int firePower) {
		this.firePower = firePower;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getHitPoints() {
		return hitPoints;
	}

	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}

	public int getMagicPoints() {
		return magicPoints;
	}

	public void setMagicPoints(int magicPoints) {
		this.magicPoints = magicPoints;
	}

//	public Set<String> getAdvantages() {
//		return advantages;
//	}
//
//	public void setAdvantages(Set<String> advantages) {
//		this.advantages = advantages;
//	}
//
//	public Set<String> getDisadvantages() {
//		return disadvantages;
//	}
//
//	public void setDisadvantages(Set<String> disadvantages) {
//		this.disadvantages = disadvantages;
//	}
//
//	public Set<String> getDamageTypes() {
//		return damageTypes;
//	}
//
//	public void setDamageTypes(Set<String> damageTypes) {
//		this.damageTypes = damageTypes;
//	}
//
//	public Set<String> getKnownSpells() {
//		return knownSpells;
//	}
//
//	public void setKnownSpells(Set<String> knownSpells) {
//		this.knownSpells = knownSpells;
//	}
//
//	public Set<String> getMoneyAndItems() {
//		return moneyAndItems;
//	}
//
//	public void setMoneyAndItems(Set<String> moneyAndItems) {
//		this.moneyAndItems = moneyAndItems;
//	}

	public static List<PlayableCharacter> getLista() {
		
		EntityManager em = new JpaUtil().getEntityManager();
		PlayableCharacterDao dao = new PlayableCharacterDao(em);
		return dao.getAllPlayableCharacters();
		
	}

	public PlayableCharacter searchCharacterById(Integer id) {
		for (PlayableCharacter character : getLista()) {
			if (character.getId() == id) {
				return character;
			}
		}
		return null;
	}

	public static PlayableCharacter searchCharacterByPlayer(Player player) {
		for (PlayableCharacter character : getLista()) {
			if (character.getPlayer().getId() == player.getId()) {
				return character;
			}
		}
		return null;
	}

}
