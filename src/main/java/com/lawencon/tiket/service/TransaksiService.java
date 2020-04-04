package com.lawencon.tiket.service;

import java.util.List;

import com.lawencon.tiket.model.Transaksi;

public interface TransaksiService {
	abstract List<Transaksi> findAll(String username, String password) throws Exception;
	abstract String insert(Transaksi transaksi, String username, String password) throws Exception;
//	abstract Pelanggan update(long id) throws Exception;
	abstract String delete(long id, String username, String password) throws Exception;
}
