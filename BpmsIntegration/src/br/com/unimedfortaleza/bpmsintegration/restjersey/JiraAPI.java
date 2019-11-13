package br.com.unimedfortaleza.bpmsintegration.restjersey;

import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import sun.misc.BASE64Encoder;

public class JiraAPI {

    private static String URL_FIND_USER = "https://jiracloud.unimedfortaleza.com.br/rest/api/2/user/search?username=";
    private static String URL_FIND_ISSUE = "https://jiracloud.unimedfortaleza.com.br/rest/api/2/issue/";
    private static String name = "t01rit0019";
    private static String password = "luizFat2";    
    
	public static void main(String[] args) {

     	JiraAPI jiraApi = new JiraAPI();
		String output = jiraApi.buscaUsuarioNoJira("t01rit0019");
		System.out.println("response: "+output);       
		
		
	}
	
   public String buscaUsuarioNoJira(String username) {
	   
		String url = URL_FIND_USER + username;
		Client restClient = Client.create();
		WebResource webResource = restClient.resource(url);
		ClientResponse resp = webResource
				.accept(MediaType.APPLICATION_JSON)
				.header("Authorization", "Basic " + getAuth())
				.type(MediaType.APPLICATION_JSON)
				.get(ClientResponse.class);
		
		JSONObject json = new JSONObject();
		json.put("Usuario", resp);   
		                                 	                                 
		String output = resp.getEntity(String.class);

//	    System.out.println("response: "+output);   
		
		return output; 
	   
   }
   
   public String buscarIssueNoJira(String issue) {
	   
 		String url = URL_FIND_USER + issue;
 		Client restClient = Client.create();
 		WebResource webResource = restClient.resource(url);
 		ClientResponse resp = webResource
 				.accept(MediaType.APPLICATION_JSON)
 				.header("Authorization", "Basic " + getAuth())
 				.type(MediaType.APPLICATION_JSON)
 				.get(ClientResponse.class);
 		
 		JSONObject json = new JSONObject();
 		json.put("Issue", resp);   
 		                                 	                                 
 		String output = resp.getEntity(String.class);

// 	    System.out.println("response: "+output);   
 		
 		return output; 
 	   
    }
   
    public String getAuth() { 
    	
		String authString = name + ":" + password;
 		return new BASE64Encoder().encode(authString.getBytes());
    	
    }
   
   

}