package com.lawencon.tiket.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.KendaraanDao;
import com.lawencon.tiket.model.TipeKendaraan;

@Repository("tipe_repo_hibernate")
public class KendaraanDaoImpl extends BaseHibernate implements KendaraanDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TipeKendaraan> findAll() throws Exception {
		Query q = em.createQuery("from TipeKendaraan");
		return q.getResultList();
	}

	@Override
	public TipeKendaraan insert(TipeKendaraan tipeKendaraan,String username, String password) throws Exception {
		em.persist(tipeKendaraan);
		return tipeKendaraan;
	}

	@Override
	public TipeKendaraan update(long id, int harga) throws Exception {
		Query q = em.createQuery(" from TipeKendaraan where tipeId = :idParam");
		q.setParameter("idParam", id);
		TipeKendaraan tipe = (TipeKendaraan) q.getSingleResult();
		tipe.setHarga(harga);
		em.merge(tipe);
		return tipe;
	}

	@Override
	public String delete(long id) throws Exception {
		Query q = em.createQuery(" from TipeKendaraan where tipeId = :idParam");
		q.setParameter("idParam", id);
		TipeKendaraan tipe = new TipeKendaraan();
		tipe = (TipeKendaraan) q.getSingleResult();
		em.remove(tipe);
		return "Data berhasil dihapus";
	}

	@Override
	public int updateJpa(long id, int harga) throws Exception {
		return 0;
		
	}

}
