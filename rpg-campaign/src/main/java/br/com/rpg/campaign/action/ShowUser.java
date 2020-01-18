package br.com.rpg.campaign.action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rpg.campaign.dao.UserDao;
import br.com.rpg.campaign.interfaces.Action;
import br.com.rpg.campaign.util.JpaUtil;

public class ShowUser implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("[ Action ] : ShowUser accessed!");

		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		EntityManager em = new JpaUtil().getEntityManager();
		UserDao dao = new UserDao(em);

		req.setAttribute("user", dao.getUserById(id));
		return "forward:formEditUser.jsp";

	}

}
