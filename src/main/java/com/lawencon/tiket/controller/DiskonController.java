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
import com.lawencon.tiket.model.Diskon;
import com.lawencon.tiket.service.DiskonService;

@RestController
public class DiskonController extends BaseController {

	@Autowired
	private DiskonService diskonService;

	@Override
	String authUser(String user) throws Exception {
		byte[] decodeBytes = Base64.getDecoder().decode(user);
		String decodeString = new String(decodeBytes);
		return decodeString;
	}

	@GetMapping("/diskon")
	public ResponseEntity<List<Diskon>> getDiskon(@RequestHeader("Authorization") String user) {
		List<Diskon> listDiskon = new ArrayList<>();
		try {
			String[] auth = authUser(user).split(":");
			listDiskon = diskonService.findAll(auth[0], auth[1]);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(listDiskon, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(listDiskon, HttpStatus.OK);
	}

	@PostMapping("/diskon/insert")
	public ResponseEntity<?> getInsertDiskon(@RequestBody String content, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			Diskon diskon = new ObjectMapper().readValue(content, Diskon.class);
			diskonService.insert(diskon, auth[0], auth[1]);
			return new ResponseEntity<>("Insert successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/diskon/update")
	public ResponseEntity<?> getUpdateDiskon(@RequestParam("diskonId") long id, @RequestParam("diskon") int diskon,
			@RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			diskonService.update(id, diskon, auth[0], auth[1]);
			return new ResponseEntity<>("Update successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/diskon/delete")
	public ResponseEntity<?> getDelete(@RequestParam("diskonId") long id, @RequestHeader("Authorization") String user) {
		try {
			String[] auth = authUser(user).split(":");
			diskonService.delete(id, auth[0], auth[1]);
			return new ResponseEntity<>("Delete successful", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Unsuccessful", HttpStatus.BAD_REQUEST);
		}
	}
}
