package com.lawencon.tiket.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.tiket.dao.PelangganDao;
import com.lawencon.tiket.model.Pelanggan;

@Service
@Transactional
public class PelangganServiceImpl implements PelangganService {

	@Autowired
	@Qualifier("pelanggan_repo_hibernate")
	private PelangganDao pelangganDao;
	
	@Autowired
	private LoginService loginService;

	@Override
	public List<Pelanggan> findAll(String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return pelangganDao.findAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String insert(Pelanggan pelanggan, String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return pelangganDao.insert(pelanggan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Pelanggan update(long id, String nama, String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return pelangganDao.update(id, nama);
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
				return pelangganDao.delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
