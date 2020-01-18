package br.com.rpg.campaign.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.rpg.campaign.model.PlayableCharacter;

public class PlayableCharacterDao {

	EntityManager em;

	public PlayableCharacterDao(EntityManager em) {
		this.em = em;
	}

	public List<PlayableCharacter> getAllPlayableCharacters() {

		em.getTransaction().begin();
		List<PlayableCharacter> listCharacter = em
				.createQuery("select object(o) from PlayableCharacter as o", PlayableCharacter.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return listCharacter;

	}

	public void editPlayableCharacterById(int id, String characterName, int points, int strength, int dexterity,
			int endurance, int armor, int firepower, int level, int hitPoints, int magicPoints) {

		PlayableCharacter character = em.find(PlayableCharacter.class, id);
		character.setName(characterName);
		character.setPoints(points);
		character.setStrength(strength);
		character.setDexterity(dexterity);
		character.setEndurance(endurance);
		character.setArmor(armor);
		character.setFirePower(firepower);
		character.setLevel(level);
		character.setHitPoints(hitPoints);
		character.setMagicPoints(magicPoints);
		em.merge(character);
		em.getTransaction().commit();
		em.close();

	}
	
public PlayableCharacter getPlayableCharacterById(int id) {
		
		em.getTransaction().begin();
		PlayableCharacter playableCharacter = em.find(PlayableCharacter.class, id);
		em.getTransaction().commit();
		em.close();
		return playableCharacter;
	}

}
