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
import com.lawencon.tiket.model.Transaksi;
import com.lawencon.tiket.service.TransaksiService;

@RestController
public class TransaksiController extends BaseController{
	
	@Autowired
	private TransaksiService transaksiService;
	
	@Override
	String authUser(String user) throws Exception {
		byte[] decodeBytes = Base64.getDecoder().decode(user);
		String decodeString = new String(decodeBytes);
		return decodeString;
	}

	@GetMapping("/transaksi")
	public ResponseEntity<List<Transaksi>> getDiskon(@RequestHeader("Authorization") String user) {
		List<Transaksi> listTransaksi = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listTransaksi = transaksiService.findAll(auth[0], auth[1]);
			return new ResponseEntity<>(listTransaksi, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listTransaksi, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/transaksi/insert")
	public ResponseEntity<?> getInsertDiskon(@RequestBody String content, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			Transaksi trans = new ObjectMapper().readValue(content, Transaksi.class);
			transaksiService.insert(trans, auth[0], auth[1]);
			return new ResponseEntity<>("Insert successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/transaksi/delete")
	public ResponseEntity<?> getDelete(@RequestParam("diskonId") long id, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			transaksiService.delete(id, auth[0], auth[1]);
			return new ResponseEntity<>("Delete successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}
}
