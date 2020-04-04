package com.lawencon.tiket.service;

import java.util.List;

import com.lawencon.tiket.model.Pelanggan;

public interface PelangganService {
	abstract List<Pelanggan> findAll(String username, String password) throws Exception;
	abstract String insert(Pelanggan pelanggan, String username, String password) throws Exception;
	abstract Pelanggan update(long id, String nama, String username, String password) throws Exception;
	abstract String delete(long id, String username, String password) throws Exception;
}
