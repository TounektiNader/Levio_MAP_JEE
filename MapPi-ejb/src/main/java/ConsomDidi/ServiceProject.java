package ConsomDidi;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import Entity.User;

@LocalBean
@Stateful
public class ServiceProject implements ServiceProjetRemote,ServiceProjetLocal{

	
	
	@Override
	public List<User> Consommation() {
		
		Client client= ClientBuilder.newClient();
		
		WebTarget target = client.target("http://localhost:38198/api/afficheAllClients");
		
		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);
		
		
		System.out.println(result);
		Gson j = new Gson();
		//ObjectMapper mapper = new ObjectMapper();
		
		List<User>  user=j.fromJson(result, new TypeToken<List<User>>(){}.getType());
		
		 reponse.close();      
       return user;
	
		
	}

	@Override
	public String sayHello() {
	
		return "coucou";
	}
	

}
