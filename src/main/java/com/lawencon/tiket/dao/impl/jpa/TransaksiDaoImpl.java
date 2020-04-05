package com.lawencon.tiket.dao.impl.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.TransaksiDao;
import com.lawencon.tiket.model.Transaksi;

@Repository("transaksi_repo_jpa")
public class TransaksiDaoImpl implements TransaksiDao{

	@Autowired
	private TransaksiRepo transaksiRepo;
	
	@Override
	public List<Transaksi> findAll() throws Exception {
		return transaksiRepo.findAll();
	}

	@Override
	public List<Transaksi> findByPelanggan() throws Exception {
		return transaksiRepo.findByPelanggan();
	}

	@Override
	public List<Transaksi> findByPelangganTotal() throws Exception {
		return transaksiRepo.fingByPelangganTotal();
	}

	@Override
	public Transaksi insert(Transaksi transaksi) throws Exception {
		return transaksiRepo.save(transaksi);
	}

	@Override
	public String delete(long id) throws Exception {
		transaksiRepo.deleteById(id);
		return "Data berhasil dihapus";
	}

}
