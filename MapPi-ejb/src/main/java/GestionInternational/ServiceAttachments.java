package GestionInternational;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import Entity.AttachmentImmigrant;
import Entity.User;

/**
 * Session Bean implementation class ServiceAttachments
 */
@Stateless
@LocalBean
public class ServiceAttachments implements ServiceAttachmentsRemote, ServiceAttachmentsLocal {

	@PersistenceContext(unitName = "MapPi-ejb")
	EntityManager em;

	public ServiceAttachments() {
		// TODO Auto-generated constructor stub
	}

	public void ajoutAttachment(AttachmentImmigrant attachment) {
		em.persist(attachment);
	}

	public AttachmentImmigrant getAttachment(int id) {
		return em.find(AttachmentImmigrant.class, id);
	}

	public void DeleteAttachment(int id) {
		em.remove(em.find(AttachmentImmigrant.class, id));
	}

	// public List<AttachmentImmigrant> findAllATachmentByDossier(int idDossier)
	// {
	// List<AttachmentImmigrant> us = new ArrayList<AttachmentImmigrant>();
	// Query req = em.createQuery("SELECT u FROM DossierImmigrant u");
	//
	//
	// TypedQuery<AttachmentImmigrant> query = em.createQuery("Select e from
	// AttachmentImmigrant e where e.idUser=:login",
	// AttachmentImmigrant.class);
	// query.setParameter("login", idDossier);
	// try {
	// us = query.getResultList();
	// } catch (NoResultException e) {
	// Logger.getAnonymousLogger();
	// }
	// return us;
	// }

}
