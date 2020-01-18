package br.com.rpg.campaign.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rpg.campaign.interfaces.Action;
import br.com.rpg.campaign.model.Campaign;
import br.com.rpg.campaign.model.DungeonMaster;

public class ShowCampaign implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("[ Action ] : ShowCampaign accessed!");

		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		Campaign campaign = new Campaign();
		Campaign target = campaign.searchCampaignById(id);

		if (target.getCampaignName().isEmpty()) {
			throw new ServletException("[ Error ] : Campaign not found!");
		}

		req.setAttribute("dmList", DungeonMaster.getLista());
		req.setAttribute("campaign", target);
		return "forward:formEditCampaign.jsp";

	}

}
