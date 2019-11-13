package br.com.unimedfortaleza.bpmsintegration.soap;

import java.io.IOException;
import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser implements Serializable {

	public static UsuarioSoap[] toJavaObject(String str) {

		
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	    
		UsuarioSoap[] usu = null;
		try {
  		    
			usu = objectMapper.readValue(str, UsuarioSoap[].class);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        return usu;
    }
}



