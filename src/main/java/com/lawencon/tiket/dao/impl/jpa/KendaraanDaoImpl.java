package com.lawencon.tiket.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.KendaraanDao;
import com.lawencon.tiket.model.TipeKendaraan;

@Repository("tipe_repo_jpa")
public class KendaraanDaoImpl implements KendaraanDao{

	@Autowired
	private KendaraanRepo kendaraanRepo;
	
	@Override
	public List<TipeKendaraan> findAll() throws Exception {
		return kendaraanRepo.findAll();
	}

	@Override
	public TipeKendaraan insert(TipeKendaraan jenisKendaraan, String username, String password) throws Exception {
		return kendaraanRepo.save(jenisKendaraan);
	}

	@Override
	public TipeKendaraan update(long id, int harga) throws Exception {
		return null;
	}

	@Override
	public String delete(long id) throws Exception {
		kendaraanRepo.deleteById(id);
		return "Data berhasil dihapus";
	}

	@Override
	public int updateJpa(long id, int harga) throws Exception {
		return kendaraanRepo.update(harga, id);
	}

}
