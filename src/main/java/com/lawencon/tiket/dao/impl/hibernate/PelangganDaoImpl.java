package com.lawencon.tiket.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.PelangganDao;
import com.lawencon.tiket.model.Pelanggan;

@Repository("pelanggan_repo_hibernate")
public class PelangganDaoImpl extends BaseHibernate implements PelangganDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Pelanggan> findAll() throws Exception {
		Query q = em.createQuery(" from Pelanggan");
		return q.getResultList();
	}

	@Override
	public String insert(Pelanggan pelanggan) throws Exception {
		em.persist(pelanggan);
		return "Berhasil ditambahkan";
	}

	@Override
	public Pelanggan update(long id, String nama) throws Exception {
		Query q = em.createQuery("from Pelanggan where pelangganId = :idParam");
		q.setParameter("idParam", id);
		Pelanggan pel = new Pelanggan();
		pel = (Pelanggan) q.getSingleResult();
		pel.setNama(nama);
		em.merge(pel);
		return pel;
	}

	@Override
	public String delete(long id) throws Exception {
		Query q = em.createQuery("from Pelanggan where pelangganId = :idParam");
		q.setParameter("idParam", id);
		Pelanggan pel = new Pelanggan();
		pel = (Pelanggan) q.getSingleResult();
		pel.setPelangganId(id);
		em.remove(pel);
		return "Data berhasil dihapus";
	}

}
