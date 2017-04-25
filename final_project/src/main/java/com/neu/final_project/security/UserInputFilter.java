package com.neu.final_project.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UserInputFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest res = (HttpServletRequest) request;
		UserInputRequestWrapper userInputRequestWrapper = new UserInputRequestWrapper((HttpServletRequest)request);
		chain.doFilter(userInputRequestWrapper, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
