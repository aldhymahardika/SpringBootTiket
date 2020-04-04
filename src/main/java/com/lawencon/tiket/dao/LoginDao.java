package com.lawencon.tiket.dao;

public interface LoginDao {
	abstract Boolean findByUsernameAndPassword(String username, String password);
}
