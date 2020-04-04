package com.lawencon.tiket.dao.impl.hibernate;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lawencon.tiket.dao.DiskonDao;
import com.lawencon.tiket.model.Diskon;

@Repository("diskon_repo_hibernate")
public class DiskonDaoImpl extends BaseHibernate implements DiskonDao{
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Diskon> findAll() throws Exception {
		Query q = em.createQuery(" from Diskon");
		return q.getResultList();
	}

	@Override
	public String insert(Diskon diskon) throws Exception {
		em.persist(diskon);
		return "Berhasil ditambahkan";
	}

	@Override
	public Diskon update(long id, int diskon) throws Exception {
		Query q = em.createQuery(" from Diskon where diskonId = :idParam");
		q.setParameter("idParam", id);
		Diskon dis = new Diskon();
		dis = (Diskon) q.getSingleResult();
		dis.setDiskon(diskon);
		em.merge(dis);
		return dis;
	}

	@Override
	public String delete(long id) throws Exception {
		Query q = em.createQuery(" from Diskon where diskonId = :idParam");
		q.setParameter("idParam", id);
		Diskon diskon = new Diskon();
		diskon = (Diskon) q.getSingleResult();
		em.remove(diskon);
		return "Data berhasil dihapus";
	}

}
