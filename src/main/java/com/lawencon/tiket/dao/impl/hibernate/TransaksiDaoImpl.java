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
	public Transaksi insert(Transaksi transaksi) throws Exception {
		em.persist(transaksi);
		return transaksi;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaksi> findByPelanggan() throws Exception {
		Query q = em.createNativeQuery("select p.nama, t.kota_asal, t.kota_tujuan, t.tgl_berangkat,tp.jenis_kendaraan, tp.harga \r\n" + 
				"from pelanggan p \r\n" + 
				"join transaksi t on p.pelanggan_id = t.pelanggan_id \r\n" + 
				"join diskon d on d.diskon_id = t.diskon_id\r\n" + 
				"join tipe_kendaraan tp on tp.tipe_id = t.tipe_id;");
		return q.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Transaksi> findByPelangganTotal() throws Exception {
		Query q = em.createNativeQuery("select\r\n" + 
				"p.nama, SUM(tp.harga) as total,\r\n" + 
				"(tp.harga*(select d2.diskon from diskon d2 where d2.diskon_id = (select t2.diskon_id from transaksi t2))) as diskon,\r\n" + 
				"(tp.harga-(tp.harga*(select d2.diskon from diskon d2 where d2.diskon_id = (select t2.diskon_id from transaksi t2)))) as harga\r\n" + 
				"from pelanggan p\r\n" + 
				"join transaksi t on t.pelanggan_id = p.pelanggan_id\r\n" + 
				"join tipe_kendaraan tp on tp.tipe_id = t.tipe_id\r\n" + 
				"join diskon d on d.diskon_id = t.diskon_id \r\n" + 
				"group by p.pelanggan_id, tp.tipe_id;");
		return q.getResultList();
	}

}
