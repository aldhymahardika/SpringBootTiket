package com.lawencon.tiket.controller;

import java.util.ArrayList;
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

import com.lawencon.tiket.model.TipeKendaraan;
import com.lawencon.tiket.service.KendaraanService;

@RestController
public class KendaraanController extends BaseController<TipeKendaraan> {

	@Autowired
	private KendaraanService kendaraanService;

	@GetMapping("/jenis")
	public ResponseEntity<List<TipeKendaraan>> getKendaraan(@RequestHeader("Authorization") String user) {
		List<TipeKendaraan> listKendaraan = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listKendaraan = kendaraanService.findAll(auth[0], auth[1]);
			return new ResponseEntity<>(listKendaraan, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listKendaraan, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/jenis/insert")
	public ResponseEntity<?> getInsertKendaraan(@RequestBody String content,
			@RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			TipeKendaraan kendaraan = readValue(content, TipeKendaraan.class);
			kendaraanService.insert(kendaraan, auth[0], auth[1]);
			return new ResponseEntity<>("Insert successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/jenis/update")
	public ResponseEntity<?> getUpdateKendaraan(@RequestParam("tipeId") long id, @RequestParam("harga") int harga,
			@RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			kendaraanService.update(id, harga, auth[0], auth[1]);
			return new ResponseEntity<>("Update successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/jenis/updateJpa")
	public ResponseEntity<?> getUpdateJPAKendaraan(@RequestParam("tipeId") long id, @RequestParam("harga") int harga,
			@RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			kendaraanService.updateJpa(id, harga, auth[0], auth[1]);
			return new ResponseEntity<>("Update successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/jenis/delete")
	public ResponseEntity<?> getDelete(@RequestParam("tipeId") long id, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			kendaraanService.delete(id, auth[0], auth[1]);
			return new ResponseEntity<>("Delete successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}
}
