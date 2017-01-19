package com.example;

import java.io.IOException;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@SpringBootApplication
@RestController
public class Wso2ResourceServerApplicationV2 {

	public static void main(String[] args) {
		SpringApplication.run(Wso2ResourceServerApplicationV2.class, args);
	}

	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user( @RequestHeader HttpHeaders headers) throws JsonParseException, JsonMappingException, IOException {
		Map<String,Object> grants = JWTUtils.decode(headers.get("X-JWT-Assertion").get(0));
		return "Hello "+grants.get("http://wso2.org/claims/enduser");
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String saveUser( @RequestBody String person) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("Posted"+person);
		return person;
	}
	
	@RequestMapping(value = "/usersecond", method = RequestMethod.POST)
	public String user ( @RequestBody String person) throws JsonParseException, JsonMappingException, IOException {
		System.out.println("You are awesome " +person);
		return person;
		
	}
	
}
