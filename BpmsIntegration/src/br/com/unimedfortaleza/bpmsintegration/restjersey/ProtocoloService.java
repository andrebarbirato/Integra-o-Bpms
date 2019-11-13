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
 

@Path("/bpmsintegrationservice/sabius/protocolo")
public class ProtocoloService {

	@Path("{issueJira}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("issueJira") String issueJira) throws JSONException {
		 
		JiraAPI jiraApi = new JiraAPI();

		String output = jiraApi.buscaUsuarioNoJira(issueJira);
		
		String result = "@Produces(\"application/json\") \n \n Output: \n\n " + output;
		return Response.status(200).entity(output).build();

	
	}
	
	
}
