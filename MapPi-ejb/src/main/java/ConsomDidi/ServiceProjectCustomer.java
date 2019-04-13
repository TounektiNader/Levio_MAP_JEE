package ConsomDidi;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javax.ws.rs.core.MediaType;
import Entity.Project;
import javax.ws.rs.core.Response;

@LocalBean
@Stateful
public class ServiceProjectCustomer implements ServiceProjectCustomerRemote,ServiceProjetCustomerLocal {

	@Override
	public List<Project> Consom(int id) {
		  //id=4;
		Client client= ClientBuilder.newClient();
		
		WebTarget target = client.target("http://localhost:38198/api/Afficher/"+id+"");
		
		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);
		
		
		System.out.println(result);
		Gson j = new Gson();
		//ObjectMapper mapper = new ObjectMapper();
		
		List<Project>  project=j.fromJson(result, new TypeToken<List<Project>>(){}.getType());
		
		 reponse.close();      
       return project;
	}

	
	
	
	
	
	@Override
	public String hi() {
		
		return "hello";
	}
	
	

}
