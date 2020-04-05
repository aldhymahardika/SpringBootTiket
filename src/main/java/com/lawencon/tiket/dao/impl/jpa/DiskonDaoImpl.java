package com.lawencon.tiket.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.DiskonDao;
import com.lawencon.tiket.model.Diskon;

@Repository("diskon_repo_jpa")
public class DiskonDaoImpl implements DiskonDao{

	@Autowired
	private DiskonRepo diskonRepo;
	
	@Override
	public List<Diskon> findAll() throws Exception {
		return diskonRepo.findAll();
	}

	@Override
	public Diskon insert(Diskon diskon) throws Exception {
		return diskonRepo.save(diskon);
	}

	@Override
	public Diskon update(long id, float diskon) throws Exception {
		return null;
	}

	@Override
	public String delete(long id) throws Exception {
		diskonRepo.deleteById(id);
		return "Data berhasil dihapus";
	}

	@Override
	public int updateJpa(long id, float diskon) throws Exception {
		return diskonRepo.update(diskon, id);
	}

}
