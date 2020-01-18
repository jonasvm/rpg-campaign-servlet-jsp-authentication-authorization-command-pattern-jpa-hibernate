package br.com.rpg.campaign.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rpg.campaign.dao.PlayerDao;
import br.com.rpg.campaign.dao.UserDao;
import br.com.rpg.campaign.interfaces.Action;
import br.com.rpg.campaign.model.PlayableCharacter;
import br.com.rpg.campaign.model.Player;
import br.com.rpg.campaign.model.User;
import br.com.rpg.campaign.util.JpaUtil;

public class UserDetails implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("[ Action ] : UserDetails accessed!");

		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		EntityManager em = new JpaUtil().getEntityManager();
		EntityManager em2 = new JpaUtil().getEntityManager();
		
		UserDao userDao = new UserDao(em);
		User user = userDao.getUserById(id);
		
		PlayerDao dao = new PlayerDao(em2);
		List<Player> listPlayer = dao.getAllPlayersByUser(user);
		
		List<PlayableCharacter> listPlayerCharacter = new ArrayList<PlayableCharacter>();

		for (Player player : listPlayer) {
			PlayableCharacter character = PlayableCharacter.searchCharacterByPlayer(player);
			if (character != null) {
				listPlayerCharacter.add(character);
			}
		}
		req.setAttribute("listOfCharacters", listPlayerCharacter);
		req.setAttribute("user", user);
		return "forward:formUserDetails.jsp";

	}

}
