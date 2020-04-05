package com.lawencon.tiket.dao;

import java.util.List;

import com.lawencon.tiket.model.Diskon;

public interface DiskonDao {
	abstract List<Diskon> findAll() throws Exception;
	abstract Diskon insert(Diskon diskon) throws Exception;
	abstract Diskon update(long id, float diskon) throws Exception;
	abstract int updateJpa(long id, float diskon) throws Exception;
	abstract String delete(long id) throws Exception;
}
