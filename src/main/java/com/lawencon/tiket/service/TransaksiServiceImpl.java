package com.lawencon.tiket.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.lawencon.tiket.dao.TransaksiDao;
import com.lawencon.tiket.model.Transaksi;

@Service
@Transactional
public class TransaksiServiceImpl implements TransaksiService {

	@Autowired
	@Qualifier("transaksi_repo_hibernate")
	private TransaksiDao transaksiDao;

	@Autowired
	private LoginService loginService;
	
	@Override
	public List<Transaksi> findAll(String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return transaksiDao.findAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Transaksi insert(Transaksi transaksi, String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return transaksiDao.insert(transaksi);
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
				return transaksiDao.delete(id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Transaksi> findByPelanggan(String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return transaksiDao.findByPelanggan();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Transaksi> findByPelangganTotal(String username, String password) throws Exception {
		try {
			if (loginService.findByUsernameAndPassword(username, password) == false) {
				return null;
			} else {
				return transaksiDao.findByPelangganTotal();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
