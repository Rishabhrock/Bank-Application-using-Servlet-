package com.abc.bankapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangeNPwd
 */

//Error occurring here in ChangeNPwd

public class ChangeNPwd extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession();
		int accno = (int) session.getAttribute("accno");
		
		String pwd = request.getParameter("npwd");
		
		Model m = new Model();
		m.setAccno(accno);
		m.setPwd(pwd);
		boolean status = m.changePwd();
		System.out.println(status);
		if(status==true)
			response.sendRedirect("/BankApplication/changePwdSuccess.html");
		else
			response.sendRedirect("/BankApplication/changePwdFail.html");
		
	}
	
}
