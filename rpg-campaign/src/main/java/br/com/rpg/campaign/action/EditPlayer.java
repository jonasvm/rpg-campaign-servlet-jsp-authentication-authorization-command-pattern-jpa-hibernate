package br.com.rpg.campaign.action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rpg.campaign.dao.PlayableCharacterDao;
import br.com.rpg.campaign.interfaces.Action;
import br.com.rpg.campaign.model.User;
import br.com.rpg.campaign.util.JpaUtil;

public class EditPlayer implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("[ Action ] : EditPlayer accessed!");

		String paramCharacterId = req.getParameter("characterId");
		Integer characterId = Integer.valueOf(paramCharacterId);

		String characterName = req.getParameter("characterName");
		int points = Integer.parseInt(req.getParameter("points"));
		int strength = Integer.parseInt(req.getParameter("strength"));
		int dexterity = Integer.parseInt(req.getParameter("dexterity"));
		int endurance = Integer.parseInt(req.getParameter("endurance"));
		int armor = Integer.parseInt(req.getParameter("armor"));
		int firepower = Integer.parseInt(req.getParameter("firepower"));
		int level = Integer.parseInt(req.getParameter("level"));
		int hitPoints = Integer.parseInt(req.getParameter("hitPoints"));
		int magicPoints = Integer.parseInt(req.getParameter("magicPoints"));
//		Set<String> advantages = new HashSet<String>();
//		advantages.add(req.getParameter("advantages"));
//		Set<String> disadvantages = new HashSet<String>();
//		disadvantages.add(req.getParameter("disadvantages"));
//		Set<String> damageTypes = new HashSet<String>();
//		damageTypes.add(req.getParameter("damageTypes"));
//		Set<String> knownSpells = new HashSet<String>();
//		knownSpells.add(req.getParameter("knownSpells"));
//		Set<String> moneyAndItems = new HashSet<String>();
//		moneyAndItems.add(req.getParameter("moneyAndItems"));

		EntityManager em = new JpaUtil().getEntityManager();
		PlayableCharacterDao dao = new PlayableCharacterDao(em);
		dao.editPlayableCharacterById(characterId, characterName, points, strength, dexterity, endurance, armor,
				firepower, level, hitPoints, magicPoints);

		req.setAttribute("playerList", User.getLista());

		return "forward:playerList.jsp";

	}

}
