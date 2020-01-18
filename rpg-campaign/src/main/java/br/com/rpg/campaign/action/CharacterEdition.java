package br.com.rpg.campaign.action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rpg.campaign.dao.PlayableCharacterDao;
import br.com.rpg.campaign.dao.UserDao;
import br.com.rpg.campaign.interfaces.Action;
import br.com.rpg.campaign.model.PlayableCharacter;
import br.com.rpg.campaign.model.User;
import br.com.rpg.campaign.util.JpaUtil;

public class CharacterEdition implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("[ Action ] : CharacterEdition accessed!");

		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);
		String paramCharacterId = req.getParameter("character");
		Integer characterId = Integer.valueOf(paramCharacterId);

		EntityManager em = new JpaUtil().getEntityManager();
		EntityManager em2 = new JpaUtil().getEntityManager();
		UserDao userDao = new UserDao(em);
		User user = userDao.getUserById(id);
		PlayableCharacterDao characterDao = new PlayableCharacterDao(em2);
		PlayableCharacter character = characterDao.getPlayableCharacterById(characterId);

		req.setAttribute("user", user);
		req.setAttribute("character", character);
		return "forward:formEditPlayer.jsp";

	}

}
