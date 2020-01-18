package br.com.rpg.campaign.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.rpg.campaign.interfaces.Action;

//@WebFilter("/gameplay")
public class ControllerFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("[ Servlet ] : ControllerFilter accessed!");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String paramAction = req.getParameter("action");
		String location = null;

		try {
			String className = "br.com.rpg.campaign.action." + paramAction;
			Class<?> actionClass = Class.forName(className);
			Object obj = actionClass.newInstance();
			Action action = (Action) obj;
			location = action.executa(req, res);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException("[ Error ] : Action filter error!" + e);
		}

		System.out.println("[ Servlet ] : Action " + paramAction + " accessed.");

		// Redirect to JSP
		String[] typeOfRedyrectAndAddress = location.split(":");

		if (typeOfRedyrectAndAddress[0].equals("forward")) {
			System.out.println("[ Controller ] : Redirecting to " + typeOfRedyrectAndAddress[1] + " with dispatcher");
			RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/view/" + typeOfRedyrectAndAddress[1]);
			rd.forward(req, res);
		} else {
			System.out
					.println("[ Controller ] : Redirecting to " + typeOfRedyrectAndAddress[1] + " with send redirect");
			res.sendRedirect("WEB-INF/view/" + typeOfRedyrectAndAddress[1]);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void destroy() {
	}

}
