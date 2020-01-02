package com.abc.bankapplication;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Transfer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		 int accno = (int)session.getAttribute("accno");
		 String amt  = request.getParameter("amt");
		 String raccno  = request.getParameter("raccno");
		 int theAmt = Integer.parseInt(amt);
		 int theRaccno = Integer.parseInt(raccno);
		 Model model = new Model();
		 model.setAccno(accno);
		 model.setBalance(theAmt);
		 model.setRaccno(theRaccno);
		 
		 boolean result = model.transfer();
		 
		 if(result)
		 {
			 response.sendRedirect("/BankApplication/transferSuccess.jsp");
		 }
		 else
		 {
			 response.sendRedirect("/BankApplication/transferFail.html");
		 }
		 		
	}
}
