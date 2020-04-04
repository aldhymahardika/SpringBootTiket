package com.lawencon.tiket.service;

import java.util.List;

import com.lawencon.tiket.model.TipeKendaraan;

public interface KendaraanService {
	abstract List<TipeKendaraan> findAll(String username, String password) throws Exception;
	abstract String insert(TipeKendaraan jenisKendaraan, String username, String password) throws Exception;
	abstract TipeKendaraan update(long id, int harga, String username, String password) throws Exception;
	abstract String delete(long id, String username, String password) throws Exception;
}
