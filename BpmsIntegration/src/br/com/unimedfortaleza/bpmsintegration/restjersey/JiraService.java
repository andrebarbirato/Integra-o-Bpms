package br.com.unimedfortaleza.bpmsintegration.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

import com.sun.jersey.api.client.ClientResponse;
 

@Path("/bpmsintegrationservice")
public class JiraService {

	@Path("{username}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(@PathParam("username") String username) throws JSONException {
		 
		JSONObject jsonObject = new JSONObject();
		String nome;
		nome = username;
//		jsonObject.put("Nome do usuário: ", nome);

		JiraAPI jiraApi = new JiraAPI();

		String output = jiraApi.buscaUsuarioNoJira(username);
		
		String result = "@Produces(\"application/json\") \n \n Output: \n\n " + output;
		return Response.status(200).entity(output).build();

	
	}
	
	
}
