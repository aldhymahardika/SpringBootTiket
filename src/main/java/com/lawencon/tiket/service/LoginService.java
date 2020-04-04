package com.lawencon.tiket.service;

public interface LoginService {
	abstract Boolean findByUsernameAndPassword(String username, String password);
}
