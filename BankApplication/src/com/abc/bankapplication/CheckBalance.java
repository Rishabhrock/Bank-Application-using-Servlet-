package com.abc.bankapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CheckBalance extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		
		Model model = new Model();
		model.setAccno(accno);
		boolean result = model.checkBalance();
		
		if(result == true)
		{
			int balance = model.getBalance();
			session.setAttribute("balance", balance);
			response.sendRedirect("/BankApplication/checkBalance.jsp");
		}
		else
		{
			response.sendRedirect("/BankApplication/errorCheckBalance.html");
		}
	}

}
