package com.lawencon.tiket.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.tiket.dao.LoginDao;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	@Qualifier("login_repo_hibernate")
	private LoginDao loginDao;
	
	@Override
	public Boolean findByUsernameAndPassword(String username, String password) {
		return loginDao.findByUsernameAndPassword(username, password);
	}

}
