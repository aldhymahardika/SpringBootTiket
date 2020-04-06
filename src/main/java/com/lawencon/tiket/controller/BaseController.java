package com.lawencon.tiket.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.boot.json.JsonParseException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseController <T>  {

	T model;
	
	public String authUser(String user) throws Exception{
		byte[] decodeBytes = Base64.getDecoder().decode(user);
		String decodeString = new String(decodeBytes);
		return decodeString;
	}

	public T readValue(String content, Class<T> valueType) throws JsonParseException, JsonMappingException, IOException {
		return new ObjectMapper().readValue(content, valueType);
	}
}
