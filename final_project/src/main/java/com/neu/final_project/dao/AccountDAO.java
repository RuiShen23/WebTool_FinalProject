package com.neu.final_project.dao;

import java.util.List;

import org.hibernate.Query;

import com.neu.final_project.pojo.Account;

public class AccountDAO extends DAO {

	// get account by account type
	public List<Account> getUserByAccountType(String accountType) {
		try {
			begin();
			String hql = "from Account where accountType = :accountType";

			Query q = getSession().createQuery(hql);
			q.setParameter("accountType", accountType);

			List<Account> accountList = q.list();

			commit();
			return accountList;
		} finally {
			close();
		}
	}
}
