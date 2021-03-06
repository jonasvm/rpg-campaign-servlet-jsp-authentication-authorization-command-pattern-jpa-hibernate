package br.com.rpg.campaign.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rpg.campaign.interfaces.Action;
import br.com.rpg.campaign.model.User;

public class ListUser implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("[ Action ] : ListUser accessed!");

		req.setAttribute("playerList", User.getLista());

		return "forward:playerList.jsp";

	}

}
