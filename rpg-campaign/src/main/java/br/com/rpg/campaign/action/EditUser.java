package br.com.rpg.campaign.action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rpg.campaign.dao.UserDao;
import br.com.rpg.campaign.interfaces.Action;
import br.com.rpg.campaign.model.User;
import br.com.rpg.campaign.util.JpaUtil;

public class EditUser implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("[ Action ] : EditUser accessed!");

		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		EntityManager em = new JpaUtil().getEntityManager();
		UserDao dao = new UserDao(em);
		dao.editUserById(id, name, email, password);

		req.setAttribute("playerList", User.getLista());

		return "forward:playerList.jsp";

	}

}
