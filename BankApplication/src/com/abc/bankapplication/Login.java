package com.abc.bankapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {


	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String custid_login = request.getParameter("CUSTID");
		String pwd_login = request.getParameter("PWD");
		
		Model model =new Model();
		model.setCustid(custid_login);
		model.setPwd(pwd_login);
		
		boolean result = model.login();
		
		if(result == true)
		{
			int accno = model.getAccno();
			
			HttpSession session = request.getSession(true);
			session.setAttribute("accno", accno);
			
			response.sendRedirect("/BankApplication/home.jsp");
			
			
		}
		
		else
		{
			
			response.sendRedirect("/BankApplication/errorLogin.html");
		}
	
		
		
	}

}
