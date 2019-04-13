package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

//import Entity.Resource;
import Entity.Test;
import Entity.User;

@Stateless
public class ServiceAuthentification implements AuthentificationLocal, AuthentificationRemote {
	@PersistenceContext(unitName = "MapPi-ejb")
	EntityManager em;

	public void Authentification() {

		// Client client = ClientBuilder.newClient();
		// WebTarget target= client.target("http://localhost:38198/api/Tests");
		// WebTarget hello =target.matrixParam(arg0, arg1);
		// Response reponse =target.request().get();
		// String result =reponse.readEntity(String.class);
		// System.out.println(result);
		// reponse.close();

		// try{
		// // URL url = new URL("http://localhost:38198/api/Tests");//your url
		// i.e fetch data from .
		// // HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// // conn.setRequestMethod("GET");
		// // conn.setRequestProperty("Accept", "application/json");
		//// if (conn.getResponseCode() != 200) {
		//// throw new RuntimeException("Failed : HTTP Error code : "
		//// + conn.getResponseCode());
		//// }
		//// InputStreamReader in = new
		// InputStreamReader(conn.getInputStream());
		//// BufferedReader br = new BufferedReader(in);
		//// String output;
		//// while ((output = br.readLine()) != null) {
		//// System.out.println(output);
		//// }
		//// conn.disconnect();
		//
		// } catch (Exception e) {
		// System.out.println("Exception in NetClientGet:- " + e);
		// }
		// }

	}

	public String Authentification(User user) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:38198/api/Login");

		Response reponse = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
		String result = reponse.readEntity(String.class);
		if (result.equals("")) {
			System.out.println("Error");
			reponse.close();
			return result;
		} else {
			System.out.println(result);
			reponse.close();
			return result;
		}
	}

	public String Register(User user) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:38198/api/Register");

		Response reponse = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
		String result = reponse.readEntity(String.class);
		System.out.println(result);
		reponse.close();
		return result;
	}

	public User lister(int id) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:38198/api/Users/"+id);

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

	public List<User> findAllEmployye() {
		List<User> us = new ArrayList<User>();
		Query req = em.createQuery("SELECT u.id FROM User u");
		try {
			us = req.getResultList();
		} catch (NoResultException e) {
			Logger.getAnonymousLogger();
		}
		return us;
	}

	public Test getTest() {

		Test u = null;

		TypedQuery<Test> query = em.createQuery("Select e from Test e where e.id=:login ", Test.class);

		query.setParameter("login", 8);

		u = query.getSingleResult();

		return u;

	}

	public User Authent(User user) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:38198/api/Login");

		User u = new User();
		Response reponse = target.request().post(Entity.entity(user, MediaType.APPLICATION_JSON));
		String result = reponse.readEntity(String.class);
		if (result.equals("")) {
			System.out.println("Error");
			reponse.close();
			return u;
		} else {
			System.out.println(result);

			// TypedQuery<User> query = em.createQuery("Select e from User e
			// where e.id=:login ", User.class);
			//
			// query.setParameter("login", 1);
			//
			// // User employe = null;
			//
			// u = query.getSingleResult();
			//
			// reponse.close();
			return u;

		}
	}

	public void test() {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:38198/api/Tests");

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();
		// List<Test>array= new ArrayList<Test>();
		// array =reponse.readEntity(new GenericType<List<Test>>() {});
		// System.out.println(array.get(0).getTestId());

		String result = reponse.readEntity(String.class);
		// final List<Test> resultt = reponse.readEntity(new
		// GenericType<List<Test>>() {
		// });
		// System.out.println(resultt.get(0).getTestId());

		System.out.println(result);

		Gson j = new Gson();
		List<Test> peop = new ArrayList<Test>();

		peop = j.fromJson(result, new TypeToken<List<Test>>() {
		}.getType());

		System.out.println(peop.get(0).getChoix1());
		reponse.close();

		// try{
		// URL url = new URL("http://localhost:38198/api/Tests");//your url i.e
		// fetch data from .
		// HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		// conn.setRequestMethod("GET");
		// conn.setRequestProperty("Accept", "application/json");
		// if (conn.getResponseCode() != 200) {
		// throw new RuntimeException("Failed : HTTP Error code : "
		// + conn.getResponseCode());
		// }
		// InputStreamReader in = new InputStreamReader(conn.getInputStream());
		// BufferedReader br = new BufferedReader(in);
		// String output;
		// while ((output = br.readLine()) != null) {
		// System.out.println(output);
		// }
		//
		//
		// conn.disconnect();
		//
		// } catch (Exception e) {
		// System.out.println("Exception in NetClientGet:- " + e);
		// }

	}
}
