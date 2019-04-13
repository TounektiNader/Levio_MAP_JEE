package GestionInternational;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entity.AttachmentImmigrant;
import Entity.DossierImmigrant;

import Entity.EtatDossier;

/**
 * Session Bean implementation class ServiceDossierImmigrant
 */
@Stateless
@LocalBean
public class ServiceDossierImmigrant implements ServiceDossierImmigrantRemote, ServiceDossierImmigrantLocal {
	@PersistenceContext(unitName = "MapPi-ejb")
	EntityManager em;

	public ServiceDossierImmigrant() {

	}

	public void ajoutDossier(DossierImmigrant dossier) {
		em.persist(dossier);
	}

	public DossierImmigrant findDossier(int id) {
		return em.find(DossierImmigrant.class, id);
	}

	public void ajouterCoursEtEnseignant(DossierImmigrant dossier, AttachmentImmigrant attachment) {
		attachment.setDossierAttachment(dossier);
		em.persist(attachment);

	}

	public void updateCoursEtEnseignant(DossierImmigrant dossier, AttachmentImmigrant attachment) {
		attachment.setDossierAttachment(dossier);
		em.merge(attachment);

	}

	// a verifier
	public void updateDossier(DossierImmigrant dossier) {
		DossierImmigrant doss = em.find(DossierImmigrant.class, dossier.getId());
		doss.setEtape(dossier.getEtape());
		doss.setEtat(dossier.getEtat());

		em.merge(doss);

	}

	public void updateDossierAttachment(DossierImmigrant dossier) {
		DossierImmigrant doss = em.find(DossierImmigrant.class, dossier.getId());
		// doss.setEtape(dossier.getEtape());
		// doss.setEtat(dossier.getEtat());
		doss.setAttachments(dossier.getAttachments());
		System.out.println(dossier.getAttachments().get(doss.getAttachments().size() - 1).getPath());

		em.persist(doss);

	}

	public List<AttachmentImmigrant> listerCours(DossierImmigrant dossier) {

		DossierImmigrant u = em.find(DossierImmigrant.class, dossier.getId());

		return u.getAttachments();
	}

	public void DeleteDossier(DossierImmigrant dossier) {
		em.remove(em.find(DossierImmigrant.class, dossier.getId()));
	}

	public List<DossierImmigrant> findAllDossier() {
		List<DossierImmigrant> us = new ArrayList<DossierImmigrant>();
		Query req = em.createQuery("SELECT u FROM DossierImmigrant u");
		try {
			us = req.getResultList();
		} catch (NoResultException e) {
			Logger.getAnonymousLogger();
		}
		return us;
	}

	public List<DossierImmigrant> findAllDossier(String pays) {
		List<DossierImmigrant> us = new ArrayList<DossierImmigrant>();
		TypedQuery<DossierImmigrant> query = em.createQuery("Select e from DossierImmigrant e where e.pays=:login ",
				DossierImmigrant.class);

		query.setParameter("login", pays);

		try {
			us = query.getResultList();
		} catch (NoResultException e) {
			Logger.getAnonymousLogger();
		}
		return us;
	}

	public DossierImmigrant getDossierByUserId(int idUser) {

		TypedQuery<DossierImmigrant> query = em.createQuery("Select e from DossierImmigrant e where e.idUser=:login",
				DossierImmigrant.class);
		query.setParameter("login", idUser);

		DossierImmigrant employe = null;
		try {
			employe = query.getSingleResult();
		} catch (NoResultException e) {
			Logger.getAnonymousLogger();
		}
		return employe;
	}

	public List<DossierImmigrant> findAllDossierAccepte() {
		List<DossierImmigrant> us = new ArrayList<DossierImmigrant>();
		TypedQuery<DossierImmigrant> query = em.createQuery("Select e from DossierImmigrant e where e.etat=:login",
				DossierImmigrant.class);
		query.setParameter("login", EtatDossier.Accepted);
		try {
			us = query.getResultList();
		} catch (NoResultException e) {
			Logger.getAnonymousLogger();
		}
		return us;
	}

}
