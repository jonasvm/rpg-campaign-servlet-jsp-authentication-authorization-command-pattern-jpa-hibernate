package br.com.rpg.campaign.action;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rpg.campaign.dao.CampaignDao;
import br.com.rpg.campaign.interfaces.Action;
import br.com.rpg.campaign.model.Campaign;
import br.com.rpg.campaign.util.JpaUtil;

public class RemoveCampaign implements Action {

	public String executa(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		System.out.println("[ Action ] : RemoveCampaign accessed!");

		String paramId = req.getParameter("id");
		Integer id = Integer.valueOf(paramId);

		EntityManager em = new JpaUtil().getEntityManager();
		CampaignDao dao = new CampaignDao(em);
		dao.removeCampaignById(id);

		req.setAttribute("campaignList", Campaign.getLista());

		return "forward:campaignList.jsp";

	}

}
