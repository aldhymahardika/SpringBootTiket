package com.lawencon.tiket.dao;

import java.util.List;


import com.lawencon.tiket.model.TipeKendaraan;

public interface KendaraanDao {
	abstract List<TipeKendaraan> findAll() throws Exception;
	abstract TipeKendaraan insert(TipeKendaraan jenisKendaraan, String username, String password) throws Exception;
	abstract TipeKendaraan update(long id, int harga) throws Exception;
	abstract int updateJpa(long id, int harga) throws Exception;
	abstract String delete(long id) throws Exception;
}
