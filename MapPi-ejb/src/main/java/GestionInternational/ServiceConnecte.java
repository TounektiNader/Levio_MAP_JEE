package GestionInternational;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Entity.User;

/**
 * Session Bean implementation class ServiceConnecte
 */
@Stateless
@LocalBean
public class ServiceConnecte implements ServiceConnecteRemote, ServiceConnecteLocal {

	/**
	 * Default constructor.
	 */
	public ServiceConnecte() {

	}

	public User lister(int id) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:38198/api/Users/" + id);

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		User peop = new User();

		peop = j.fromJson(result, new TypeToken<User>() {
		}.getType());

		reponse.close();
		return peop;

	}

	public List<User> getListUsers() {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:38198/api/Users");

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		List<User> peop = new ArrayList<User>();

		peop = j.fromJson(result, new TypeToken<List<User>>() {
		}.getType());

		reponse.close();
		return peop;

	}

	public User getUserConecte(String email) {
		List<User> users = getListUsers();
		User userConnecte = null;
		for (User user : users) {
			if (user.getEmail().equals(email)) {

				userConnecte = user;
				
			}
		}
		System.out.println(userConnecte.getId());
		return userConnecte;
	}
}
