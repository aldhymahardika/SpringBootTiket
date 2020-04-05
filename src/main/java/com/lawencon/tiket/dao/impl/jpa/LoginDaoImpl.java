package com.lawencon.tiket.dao.impl.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.LoginDao;
import com.lawencon.tiket.model.LoginUser;

@Repository("login_repo_jpa")
public class LoginDaoImpl implements LoginDao {

	@Autowired
	private LoginRepo loginRepo;

	@Override
	public Boolean findByUsernameAndPassword(String username, String password) {
		LoginUser user = null;
		try {
			user = loginRepo.findUser(username, password);
		} catch (Exception e) {

		}
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

}
