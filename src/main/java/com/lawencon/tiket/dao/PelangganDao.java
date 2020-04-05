package com.lawencon.tiket.dao;

import java.util.List;

import com.lawencon.tiket.model.Pelanggan;

public interface PelangganDao {
	abstract List<Pelanggan> findAll() throws Exception;
	abstract Pelanggan insert(Pelanggan pelanggan) throws Exception;
	abstract Pelanggan update(long id, String nama) throws Exception;
	abstract int updateJpa(long id, String nama) throws Exception;
	abstract String delete(long id) throws Exception;
}
