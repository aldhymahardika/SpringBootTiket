package com.lawencon.tiket.dao;

import java.util.List;

import com.lawencon.tiket.model.Pelanggan;
import com.lawencon.tiket.model.Transaksi;

public interface TransaksiDao {
	abstract List<Transaksi> findAll() throws Exception;
	abstract String insert(Transaksi transaksi) throws Exception;
//	abstract Pelanggan update(long id) throws Exception;
	abstract String delete(long id) throws Exception;
}
