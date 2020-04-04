package com.lawencon.tiket.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.tiket.dao.KendaraanDao;
import com.lawencon.tiket.model.TipeKendaraan;

@Service
@Transactional
public class KendaraanServiceImpl implements KendaraanService {

	@Autowired
	@Qualifier("tipe_repo_hibernate")
	private KendaraanDao kendaraanDao;
	
	@Autowired
	private LoginService loginService;

	@Override
	public List<TipeKendaraan> findAll(String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return kendaraanDao.findAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String insert(TipeKendaraan jenisKendaraan, String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return kendaraanDao.insert(jenisKendaraan);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public TipeKendaraan update(long id, int harga, String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return kendaraanDao.update(id, harga);
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
				return kendaraanDao.delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
