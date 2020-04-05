package com.lawencon.tiket.service;

import java.util.List;

import com.lawencon.tiket.model.Transaksi;

public interface TransaksiService {
	abstract List<Transaksi> findAll(String username, String password) throws Exception;
	abstract List<Transaksi> findByPelanggan(String username, String password) throws Exception;
	abstract List<Transaksi> findByPelangganTotal(String username, String password) throws Exception;
	abstract Transaksi insert(Transaksi transaksi, String username, String password) throws Exception;
	abstract String delete(long id, String username, String password) throws Exception;
}
