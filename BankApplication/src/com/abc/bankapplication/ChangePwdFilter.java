package com.abc.bankapplication;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;


public class ChangePwdFilter implements Filter {

    
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		
		String nwpwd = request.getParameter("npwd");
		String cnfpwd = request.getParameter("cnpwd");
		if(nwpwd.equals(cnfpwd))
		{
			chain.doFilter(request, response);
		}
		else
		{
			((HttpServletResponse)response).sendRedirect("/BankApplication/errorChangePwd.jsp");
		}

	}

	

}
