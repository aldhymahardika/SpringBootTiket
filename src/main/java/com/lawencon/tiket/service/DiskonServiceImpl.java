package com.lawencon.tiket.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.tiket.dao.DiskonDao;
import com.lawencon.tiket.model.Diskon;

@Service
@Transactional
public class DiskonServiceImpl implements DiskonService {

	@Autowired
	@Qualifier("diskon_repo_hibernate")
	private DiskonDao diskonDao;

	@Autowired
	private LoginService loginService;

	@Override
	public List<Diskon> findAll(String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return diskonDao.findAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String insert(Diskon diskon, String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return diskonDao.insert(diskon);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Diskon update(long id, int diskon, String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return diskonDao.update(id, diskon);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String delete(long id, String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return diskonDao.delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
