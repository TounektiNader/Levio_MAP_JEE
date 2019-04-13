package GestionInternational;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import Entity.DossierImmigrant;
import Entity.Folder;
import Entity.JobRequest;
import Entity.OfferJob;

/**
 * Session Bean implementation class ServiceJobRequest
 */
@Stateless
@LocalBean
public class ServiceJobRequest implements ServiceJobRequestRemote, ServiceJobRequestLocal {
	@PersistenceContext(unitName = "MapPi-ejb")
	EntityManager em;

	public ServiceJobRequest() {

	}

	public List<JobRequest> getJobRequestByOffer(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:38198/api/JobRequests/" + id);

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		List<JobRequest> peop = new ArrayList<JobRequest>();

		peop = j.fromJson(result, new TypeToken<List<JobRequest>>() {
		}.getType());

		reponse.close();
		return peop;

	}

	public List<OfferJob> getOffers() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:38198/api/Folders");

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		List<OfferJob> peop = new ArrayList<OfferJob>();

		peop = j.fromJson(result, new TypeToken<List<OfferJob>>() {
		}.getType());

		System.out.println(peop.get(0).getJobType());
		reponse.close();
		return peop;

	}

	public Folder getFolder(int id) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:38198/api/Folders/" + id);

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		Folder peop = new Folder();

		peop = j.fromJson(result, new TypeToken<Folder>() {
		}.getType());

		reponse.close();
		return peop;

	}



	public void updateFolderToAssign(int idFolder) {
		Folder doss = em.find(Folder.class,idFolder);
		doss.setEtape(4);
		doss.setState("Assign");
		em.merge(doss);

	}

	// public List<JobRequest> findAllJobRequest(int id ) {
	// List<JobRequest> us = new ArrayList<JobRequest>();
	// TypedQuery<DossierImmigrant> query = em.createQuery("Select e from
	// JobRequest e where e.pays=:login ",
	// DossierImmigrant.class);
	//
	// query.setParameter("login", pays);
	//
	// try {
	// us = query.getResultList();
	// } catch (NoResultException e) {
	// Logger.getAnonymousLogger();
	// }
	// return us;
	// }
	public List<JobRequest> getJobRequetAssign(int idOffer) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:38198/JobRequests/GetJobAssign?id=" + idOffer);

		Response reponse = target.request(MediaType.APPLICATION_JSON).get();

		String result = reponse.readEntity(String.class);

		System.out.println(result);

		Gson j = new Gson();
		List<JobRequest> peop = new ArrayList<JobRequest>();

		peop = j.fromJson(result, new TypeToken<List<JobRequest>>() {
		}.getType());

		// System.out.println(peop.get(0).getJobType());
		reponse.close();
		return peop;

	}

}
