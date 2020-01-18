package br.com.rpg.campaign.action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.rpg.campaign.dao.UserDao;
import br.com.rpg.campaign.interfaces.Action;
import br.com.rpg.campaign.model.User;
import br.com.rpg.campaign.util.JpaUtil;

public class RemoveUser implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("[ Action ] : RemoveUser accessed!");

		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		EntityManager em = new JpaUtil().getEntityManager();
		UserDao dao = new UserDao(em);
		dao.removeUserById(id);

		req.setAttribute("playerList", User.getLista());

		HttpSession session = req.getSession();
		User userCompare = (User) session.getAttribute("loggedUser");
		if (userCompare.getId() == id) {
			session.invalidate();
			System.out.println("[ Action ] : Removing and logging out user!");
			return "forward:logout.jsp";
		}

		return "forward:playerList.jsp";

	}

}
