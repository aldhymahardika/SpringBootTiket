package com.lawencon.tiket.controller;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lawencon.tiket.model.Pelanggan;
import com.lawencon.tiket.service.PelangganService;

@RestController
public class PelangganController extends BaseController{
	
	@Autowired
	private PelangganService pelangganService;
	
	@Override
	String authUser(String user) throws Exception {
		byte[] decodeBytes = Base64.getDecoder().decode(user);
		String decodeString = new String(decodeBytes);
		return decodeString;
	}

	@GetMapping("/pelanggan")
	public ResponseEntity<List<Pelanggan>> getPelanggan(@RequestHeader("Authorization") String user) {
		List<Pelanggan> listPelanggan = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listPelanggan = pelangganService.findAll(auth[0], auth[1]);
			return new ResponseEntity<>(listPelanggan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listPelanggan, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/pelanggan/insert")
	public ResponseEntity<?> getInsertPelanggan(@RequestBody String content, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			Pelanggan customer = new ObjectMapper().readValue(content, Pelanggan.class);
			pelangganService.insert(customer, auth[0], auth[1]);
			return new ResponseEntity<>("Insert successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/pelanggan/update")
	public ResponseEntity<?> getUpdatePelanggan(@RequestParam("pelangganId") long id, @RequestParam("nama") String nama,
			@RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			pelangganService.update(id, nama, auth[0], auth[1]);
			return new ResponseEntity<>("Update successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/pelanggan/updateJpa")
	public ResponseEntity<?> getUpdateJPAPelanggan(@RequestParam("pelangganId") long id, @RequestParam("nama") String nama,
			@RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			pelangganService.updateJpa(id, nama, auth[0], auth[1]);
			return new ResponseEntity<>("Update successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/pelanggan/delete")
	public ResponseEntity<?> getDelete(@RequestParam("pelangganId") long id, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			pelangganService.delete(id, auth[0], auth[1]);
			return new ResponseEntity<>("Delete successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}
}
