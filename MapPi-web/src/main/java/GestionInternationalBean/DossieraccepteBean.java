package GestionInternationalBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;

import Entity.DossierImmigrant;
import Entity.JobRequest;
import GestionInternational.ServiceDossierImmigrantLocal;
import GestionInternational.ServiceJobRequestLocal;
import GestionInternational.ServiceMinistereLocal;
import Utils.AuthentificationLocal;

@ManagedBean
@ViewScoped
public class DossieraccepteBean {

	private List<DossierImmigrant> dossiers;
	private List<DossierImmigrant> dossiersRempli;

	private List<DossierImmigrant> droppedCars;

	private DossierImmigrant selectedCar;

	@EJB
	ServiceDossierImmigrantLocal dossierLocal;

	@EJB
	ServiceJobRequestLocal authLocal;

	@EJB
	AuthentificationLocal auth;

	private List<JobRequest> jobs;

	@PostConstruct
	public void init() {
		// droppedCars = new ArrayList<JobRequest>();
		dossiersRempli = new ArrayList<DossierImmigrant>();

		dossiers = dossierLocal.findAllDossierAccepte();
		jobs = authLocal.getJobRequetAssign(1);

		for (DossierImmigrant dossier : dossiers) {

			for (JobRequest job : jobs) {
				if (job.getDateApply() == dossier.getIdUser()) {

					dossiersRempli.add(dossier);
				}

			}
			// System.out.println(jobRequest.getDateApply());
			// System.out.println(jobRequest.getSpeciality());
			// System.out.println(jobRequest.getState() + "nader");
			// // System.out.println(jobRequest.getDateApply());
			// jobRequest.setUser(auth.lister(jobRequest.getDateApply()));
		}
		droppedCars = new ArrayList<DossierImmigrant>();
	}

	public void onCarDrop(DragDropEvent ddEvent) {
		DossierImmigrant car = ((DossierImmigrant) ddEvent.getData());
		System.out.println("naderaaaaaaaaaaS");
		droppedCars.add(car);
		jobs.remove(car);
	}

	public List<DossierImmigrant> getDossiers() {
		return dossiers;
	}

	public void setDossiers(List<DossierImmigrant> dossiers) {
		this.dossiers = dossiers;
	}

	public List<DossierImmigrant> getDroppedCars() {
		return droppedCars;
	}

	public void setDroppedCars(List<DossierImmigrant> droppedCars) {
		this.droppedCars = droppedCars;
	}

	public DossierImmigrant getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(DossierImmigrant selectedCar) {
		this.selectedCar = selectedCar;
	}

	public List<DossierImmigrant> getDossiersRempli() {
		return dossiersRempli;
	}

	public void setDossiersRempli(List<DossierImmigrant> dossiersRempli) {
		this.dossiersRempli = dossiersRempli;
	}

}
