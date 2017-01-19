package com.example;

import java.io.IOException;
import java.util.Map;

import org.apache.axiom.util.base64.Base64Utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JWTUtils {

	    @SuppressWarnings("unchecked")
		public static Map<String,Object> decode(String strEncoded) throws JsonParseException, JsonMappingException, IOException{
	    	ObjectMapper mapper = new ObjectMapper();
			
			String signedJWTToken = strEncoded;
			
			String[] split_string = signedJWTToken.split("\\.");
	        //String base64EncodedHeader = split_string[0];
	        String base64EncodedBody = split_string[1];

	        //String decodedHeader = new String(Base64Utils.decode(base64EncodedHeader));
	        String decodedBody = new String(Base64Utils.decode(base64EncodedBody));
	        decodedBody = decodedBody.replace("\\", "");

	        return mapper.readValue(decodedBody, Map.class);
	    }
}
