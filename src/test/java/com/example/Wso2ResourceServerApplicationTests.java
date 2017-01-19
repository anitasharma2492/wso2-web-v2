package com.example;

import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.axiom.util.base64.Base64Utils;
import org.junit.Test;
import org.springframework.boot.json.BasicJsonParser;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Wso2ResourceServerApplicationTests {

	@Test
	public void contextLoads() throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		
		String signedJWTToken = "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6ImFfamhOdXMyMUtWdW9GeDY1TG1rVzJPX2wxMCJ9.eyJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC9hcHBsaWNhdGlvbm5hbWUiOiJ0ZXN0LWFwcCIsImlzcyI6IndzbzIub3JnXC9wcm9kdWN0c1wvYW0iLCJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC9sYXN0bmFtZSI6Imxhc3RuYW1lIiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvYXBwbGljYXRpb25pZCI6IjIiLCJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC9lbmR1c2VyIjoidXNlcjFAY2FyYm9uLnN1cGVyIiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvdmVyc2lvbiI6IjEuMCIsImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL2tleXR5cGUiOiJQUk9EVUNUSU9OIiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvZW5kdXNlclRlbmFudElkIjoiLTEyMzQiLCJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC9naXZlbm5hbWUiOiJmaXJzdG5hbWUiLCJleHAiOjE0ODM2OTA2NzIsImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL3N1YnNjcmliZXIiOiJ1c2VyMSIsImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL2FwaWNvbnRleHQiOiJcL3NwcmluZy1hcGlcLzEuMCIsImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL3RpZXIiOiJVbmxpbWl0ZWQiLCJodHRwOlwvXC93c28yLm9yZ1wvY2xhaW1zXC91c2VydHlwZSI6IkFQUExJQ0FUSU9OIiwiaHR0cDpcL1wvd3NvMi5vcmdcL2NsYWltc1wvcm9sZSI6WyJJbnRlcm5hbFwvc3Vic2NyaWJlciIsIkludGVybmFsXC9ldmVyeW9uZSIsIkFwcGxpY2F0aW9uXC91c2VyMV90ZXN0LWFwcF9QUk9EVUNUSU9OIiwiSW50ZXJuYWxcL2lkZW50aXR5Il0sImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL2FwcGxpY2F0aW9udGllciI6IlVubGltaXRlZCIsImh0dHA6XC9cL3dzbzIub3JnXC9jbGFpbXNcL29yZ2FuaXphdGlvbiI6ImVtYWlsIn0=.XnA6NJTixlpx6ya9naOUYRUF4D+ZI7xBaGX35NAfmAkaUBjyKWVjNH+l0e7/ceoB+MeJv0oQQ7m29Z3tuO4xRYbhC5NciDLefjbSd+ZbMEwQH92aIlSlWkpOFa2XrOr9u52ZJa+cUf0n82sNCvW2DIIa9yA9v/p/V15Rdgk7zdI=";

		System.out.println(signedJWTToken);
		
		String[] split_string = signedJWTToken.split("\\.");
        String base64EncodedHeader = split_string[0];
        String base64EncodedBody = split_string[1];
        @SuppressWarnings("unused")
		String base64EncodedSignature = split_string[2];

        String decodedHeader = new String(Base64Utils.decode(base64EncodedHeader));
        System.out.println("Decoded Header :");
        System.out.println("===========================");
        System.out.println(decodedHeader);


        System.out.println("Decoded Body :");
        System.out.println("============================");
        String decodedBody = new String(Base64Utils.decode(base64EncodedBody));
        decodedBody = decodedBody.replace("\\", "");
        System.out.println(decodedBody);
        
        @SuppressWarnings("unchecked")
		Map<String,Object> grants = mapper.readValue(decodedBody, Map.class);
        
        System.out.println("First Name:"+grants.get("http://wso2.org/claims/givenname"));
        System.out.println("Last Name:"+grants.get("http://wso2.org/claims/lastname"));
        System.out.println("Username:"+grants.get("http://wso2.org/claims/enduser"));
        System.out.println("Roles:"+grants.get("http://wso2.org/claims/role"));
		
	}

}
