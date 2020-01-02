package com.abc.bankapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ChangePwd extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		
		String npwd = request.getParameter("npwd");
		
		Model model =new Model();
		model.setAccno(accno);
		model.setPwd(npwd);
		
		boolean result = model.changePwd();
		if(result == true)
		{
			response.sendRedirect("/BankApplication/changePwdSuccess.html");
		}
		else
		{
			response.sendRedirect("/BankApplication/changePwdFail.html");
		}
	}

}
