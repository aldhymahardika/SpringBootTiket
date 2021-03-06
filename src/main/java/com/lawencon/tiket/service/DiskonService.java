package com.lawencon.tiket.service;

import java.util.List;

import com.lawencon.tiket.model.Diskon;

public interface DiskonService {
	abstract List<Diskon> findAll(String username, String password) throws Exception;
	abstract Diskon insert(Diskon diskon, String username, String password) throws Exception;
	abstract Diskon update(long id, float diskon, String username, String password) throws Exception;
	abstract int updateJpa(long id, float diskon, String username, String password) throws Exception;
	abstract String delete(long id, String username, String password) throws Exception;
	
}
