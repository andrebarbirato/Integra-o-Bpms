package br.com.unimedfortaleza.bpmsintegration.restjersey;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.owlike.genson.Genson;
import com.owlike.genson.GensonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Proxy;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;
import sun.misc.BASE64Encoder;

public class SabiusAPI {

    private static String URL_CRIAR_ATENDIMENTO = "http://tf1jboss.unimedfortaleza.com.br:8081/sabius-servicos-web/rest-servicos/atendimento/abrir";
    private static String URL_ENCERRAR_ATENDIMENTO = "http://tf1jboss.unimedfortaleza.com.br:8081/sabius-servicos-web/rest-servicos/atendimento/v2/encerrar";
    private static String name = "nilson";
    private static String password = "nilson";    
    
	public static void main(String[] args) {

		SabiusAPI sabiusApi = new SabiusAPI();
	    Genson genson = new Genson();
		
		SolicitacaoAutorizacao solicitacaoAutorizacaoVO = new SolicitacaoAutorizacao();
		solicitacaoAutorizacaoVO.setPontoAtendimento("1");
		solicitacaoAutorizacaoVO.setCodUsuarioAuditoria("CHATBOT");
		solicitacaoAutorizacaoVO.setUnimedAtendimento("63");
		solicitacaoAutorizacaoVO.setUnimedCarteira("63");
		solicitacaoAutorizacaoVO.setCodCarteira("002005507891");
		solicitacaoAutorizacaoVO.setDvCarteira("5");
		solicitacaoAutorizacaoVO.setClassificacaoAtendimento("1093");
		solicitacaoAutorizacaoVO.setCodCaixa("CHATBOT");
		solicitacaoAutorizacaoVO.setObservacoes("Solicitação de segunda via de fatura");
		String singlePersonJson = genson.serialize(solicitacaoAutorizacaoVO);
		singlePersonJson = "{\"solicitacaoAutorizacaoVO\":"+singlePersonJson;		
		singlePersonJson = singlePersonJson.replaceAll("]", "}")+"}";
		
		solicitacaoAutorizacaoVO = sabiusApi.criarAtendimento(singlePersonJson, solicitacaoAutorizacaoVO);

		singlePersonJson = genson.serialize(solicitacaoAutorizacaoVO);
		singlePersonJson = "{\"solicitacaoAutorizacaoVO\":"+singlePersonJson;		
		singlePersonJson = singlePersonJson.replaceAll("]", "}")+"}";


		String output = sabiusApi.encerrarAtendimento(singlePersonJson);
       
       System.out.println("Numero do Protocolo: " + solicitacaoAutorizacaoVO.getNumeroProtocolo()+
    		              " Numero da sessão: " +   solicitacaoAutorizacaoVO.getpNumSessao() + 
    		              " Numero de atendimento: " + solicitacaoAutorizacaoVO.getNumeroAtendimento() +
                          " output: " + output );
		
	}
	
   public SolicitacaoAutorizacao criarAtendimento(String jsonArg, SolicitacaoAutorizacao solicitacao) {


	    JSONObject json = SabiusAPI.call(URL_CRIAR_ATENDIMENTO, jsonArg);

		solicitacao.setNumeroProtocolo(json.getJSONObject("retorno")
	               .getJSONObject("solicitacaoAutorizacaoVO")
	               .getJSONObject("myHashMap")
	               .getString("numeroProtocolo"));
		
		solicitacao.setpNumSessao(json.getJSONObject("retorno")
	               .getJSONObject("solicitacaoAutorizacaoVO")
	               .getJSONObject("myHashMap")
	               .getString("pNumSessao"));

		solicitacao.setNumeroAtendimento(json.getJSONObject("retorno")
	               .getJSONObject("solicitacaoAutorizacaoVO")
	               .getJSONObject("myHashMap")
	               .getString("numeroAtendimento"));
		
		return solicitacao; 
	   
   }
   
   public String encerrarAtendimento(String jsonArg) {
	   
	    JSONObject json = SabiusAPI.call(URL_ENCERRAR_ATENDIMENTO, jsonArg);
		String mensagem = json.getString("mensagem");
 		
 		return mensagem; 
 	   
    }
   
    private String getAuth() { 
    	
		String authString = name + ":" + password;
 		return new BASE64Encoder().encode(authString.getBytes());
    	
    }
   
    private static JSONObject call(String url, String body) { 
    	
		HttpResponse<JsonNode> response = Unirest.post(url)
				  .header("Content-Type", "application/json")
				  .header("Authorization", "Basic bmlsc29uOm5pbHNvbg==")
				  .header("Accept", "*/*")
				  .header("Cache-Control", "no-cache")
				  .header("Accept-Encoding", "gzip, deflate")
				  .header("Connection", "keep-alive")
				  .header("cache-control", "no-cache")
				  .body(body)
				  .asJson();
    
		   return response.getBody().getObject(); 
     }
   

}