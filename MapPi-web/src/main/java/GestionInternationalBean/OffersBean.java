package GestionInternationalBean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entity.JobRequest;
import Entity.OfferJob;
import GestionInternational.ServiceJobRequestLocal;

@ManagedBean
@SessionScoped
public class OffersBean {

	private OfferJob offer;
	private int id;
	private List<OfferJob> offers;
	private List<JobRequest> jobs;

	@EJB
	ServiceJobRequestLocal authLocal;

	
	
	public List<OfferJob> getOffers() {
		offers = authLocal.getOffers();
		return offers;
	}

	public void setOffers(List<OfferJob> offers) {
		this.offers = offers;
	}

	public OfferJob getOffer() {
		return offer;
	}

	public void setOffer(OfferJob offer) {
		this.offer = offer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
