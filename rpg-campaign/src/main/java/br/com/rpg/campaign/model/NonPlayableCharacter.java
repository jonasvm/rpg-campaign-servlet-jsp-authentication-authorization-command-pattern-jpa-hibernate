package br.com.rpg.campaign.model;

import java.util.Set;

/**
 * 
 * The Class NonPlayableCharacter extends the class Character and represents a
 * character owned by a campaign. It is used by the Campaign, and contains only
 * the implementation of super class constructor and abstract methods. Every
 * NonPlayableCharacter is associated with a campaign (i.e. npcs and monsters).
 * 
 * @author jonas
 * @version 1.4
 * @since 02/10/2019
 *
 */
public class NonPlayableCharacter extends PlayableCharacter {

	public NonPlayableCharacter(String name, int points, int strength, int dexterity, int endurance, int armor,
			int firePower, int level, int hitPoints, int magicPoints, Set<String> advantages, Set<String> disadvantages,
			Set<String> damageTypes, Set<String> knownSpells, Set<String> moneyAndItems) {

//		super(name, points, strength, dexterity, endurance, armor, firePower, level, hitPoints, magicPoints, advantages,
//				disadvantages, damageTypes, knownSpells, moneyAndItems);

	}

}
