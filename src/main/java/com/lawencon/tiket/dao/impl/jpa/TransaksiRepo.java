package com.lawencon.tiket.dao.impl.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.tiket.model.Transaksi;

@Repository
public interface TransaksiRepo extends JpaRepository<Transaksi, Long> {
	//gabisa
	@Query(value="select\\r\\n\" + \r\n" + 
			"				\"p.nama, SUM(tp.harga) as total,\\r\\n\" + \r\n" + 
			"				\"(tp.harga*(select d2.diskon from diskon d2 where d2.diskon_id = (select t2.diskon_id from transaksi t2))) as diskon,\\r\\n\" + \r\n" + 
			"				\"(tp.harga-(tp.harga*(select d2.diskon from diskon d2 where d2.diskon_id = (select t2.diskon_id from transaksi t2)))) as harga\\r\\n\" + \r\n" + 
			"				\"from pelanggan p\\r\\n\" + \r\n" + 
			"				\"join transaksi t on t.pelanggan_id = p.pelanggan_id\\r\\n\" + \r\n" + 
			"				\"join tipe_kendaraan tp on tp.tipe_id = t.tipe_id\\r\\n\" + \r\n" + 
			"				\"join diskon d on d.diskon_id = t.diskon_id \\r\\n\" + \r\n" + 
			"				\"group by p.pelanggan_id, tp.tipe_id", nativeQuery=true)
	abstract List<Transaksi> fingByPelangganTotal() throws Exception;
	
	//gabisa
	@Query(value="select p.nama, t.kota_asal, t.kota_tujuan, t.tgl_berangkat,tp.jenis_kendaraan, tp.harga \\r\\n\" + \r\n" + 
			"				\"from pelanggan p \\r\\n\" + \r\n" + 
			"				\"join transaksi t on p.pelanggan_id = t.pelanggan_id \\r\\n\" + \r\n" + 
			"				\"join diskon d on d.diskon_id = t.diskon_id\\r\\n\" + \r\n" + 
			"				\"join tipe_kendaraan tp on tp.tipe_id = t.tipe_id", nativeQuery=true)
	abstract List<Transaksi> findByPelanggan() throws Exception;
}
