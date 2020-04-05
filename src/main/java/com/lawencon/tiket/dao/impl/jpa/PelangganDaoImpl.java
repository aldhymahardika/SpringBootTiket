package com.lawencon.tiket.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.PelangganDao;
import com.lawencon.tiket.model.Pelanggan;

@Repository("pelanggan_repo_jpa")
public class PelangganDaoImpl implements PelangganDao {

	@Autowired
	private PelangganRepo pelangganRepo;
	
	@Override
	public List<Pelanggan> findAll() throws Exception {
		return pelangganRepo.findAll();
	}

	@Override
	public Pelanggan insert(Pelanggan pelanggan) throws Exception {
		return pelangganRepo.save(pelanggan);
	}

	@Override
	public Pelanggan update(long id, String nama) throws Exception {
		return null;
	}

	@Override
	public String delete(long id) throws Exception {
		pelangganRepo.deleteById(id);
		return "Data berhasil dihapus";
	}

	@Override
	public int updateJpa(long id, String nama) throws Exception {
		return pelangganRepo.update(nama, id);
	}

}
