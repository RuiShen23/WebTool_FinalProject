package com.neu.final_project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neu.final_project.dao.AccountDAO;
import com.neu.final_project.pojo.Account;

@Controller
public class AccountController {
			
	@Autowired
	@Qualifier("accountDAO")
	AccountDAO accountDAO;
		
	//ajax - admin view accounts
	@RequestMapping(value="account/admin-view-accounts", method=RequestMethod.POST)
	@ResponseBody
	public List<Account> adminViewAccounts(HttpServletRequest request){
		String accountType = request.getParameter("accountType");
			
		List<Account> accountList = accountDAO.getUserByAccountType(accountType);
		request.setAttribute("accountList", accountList);
			
		return accountList;
	}
}
