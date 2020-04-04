package com.lawencon.tiket.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.TransaksiDao;
import com.lawencon.tiket.model.Transaksi;

@Repository("transaksi_repo_hibernate")
public class TransaksiDaoImpl extends BaseHibernate implements TransaksiDao {
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Transaksi> findAll() throws Exception {
		Query q = em.createQuery(" from Transaksi");
		return q.getResultList();
	}

	@Override
	public String insert(Transaksi transaksi) throws Exception {
		em.persist(transaksi);
		return "Berhasil ditambahkan";
	}

	@Override
	public String delete(long id) throws Exception {
		Query q = em.createQuery(" from Transaksi where transId = : idParam");
		q.setParameter("idParam", id);
		Transaksi trans = new Transaksi();
		trans = (Transaksi) q.getSingleResult();
		em.remove(trans);
		return "Data berhasil dihapus";
	}

}
