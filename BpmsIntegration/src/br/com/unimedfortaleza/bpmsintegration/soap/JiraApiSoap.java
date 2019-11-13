package br.com.unimedfortaleza.bpmsintegration.soap;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Provider;

import org.json.*;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import br.com.unimedfortaleza.bpmsintegration.restjersey.JiraAPI;

@WebService
public class JiraApiSoap {

	@WebMethod
	public String findUsers(String criterio) {
		
		JiraAPI jiraApi = new JiraAPI();
		String xmlString = null;
		String output = jiraApi.buscaUsuarioNoJira(criterio);
		String outputTemp = output.replaceAll("16x16", "minusculo").replaceAll("24x24", "pequeno").replaceAll("32x32", "medio").replaceAll("48x48", "grande");
	//	outputTemp = outputTemp.substring(1,outputTemp.length()-1);
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		String resposta = "";
		try {
            
			UsuarioSoap[] usu = mapper.readValue(outputTemp, UsuarioSoap[].class);
		    List<UsuarioSoap> ppl2 = Arrays.asList(mapper.readValue(outputTemp, UsuarioSoap[].class));
//		    ppl2.stream().forEach(x -> 
//		    	System.out.println(x.getName()+","+x.getDisplayName()+","+x.getEmailAddress())
//		    		);
			
		    for (Iterator iterator = ppl2.iterator(); iterator.hasNext();) {
				UsuarioSoap x = (UsuarioSoap) iterator.next();
				resposta = resposta+x.getName()+","+x.getDisplayName()+","+x.getEmailAddress()+"|";
			}
		    
		   		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resposta = ("".equals(resposta))?"Não existe colaborador com este critério":resposta.substring(0, resposta.length()-1);

		return resposta;
	}


}
