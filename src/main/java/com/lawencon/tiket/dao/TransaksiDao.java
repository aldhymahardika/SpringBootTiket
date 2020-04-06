package com.lawencon.tiket.dao;

import java.util.List;

import com.lawencon.tiket.model.Transaksi;

public interface TransaksiDao {
	abstract List<Transaksi> findAll() throws Exception;
	abstract List<Transaksi> findByPelanggan() throws Exception;
	abstract List<Transaksi> findByPelangganTotal() throws Exception;
	abstract Transaksi insert(Transaksi transaksi) throws Exception;
	abstract String delete(long id) throws Exception;
}
