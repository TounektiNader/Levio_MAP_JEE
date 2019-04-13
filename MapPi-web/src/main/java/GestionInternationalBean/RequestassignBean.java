package GestionInternationalBean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.DragDropEvent;

import Entity.JobRequest;
import GestionInternational.ServiceJobRequestLocal;
import Utils.AuthentificationLocal;

@ManagedBean
@ViewScoped
public class RequestassignBean {

	@EJB
	ServiceJobRequestLocal authLocal;

	@EJB
	AuthentificationLocal auth;
	private List<JobRequest> jobs;
	private List<JobRequest> droppedCars;

	private JobRequest selectedCar;

	@PostConstruct
	public void init() {
		// droppedCars = new ArrayList<JobRequest>();
		droppedCars = new ArrayList<JobRequest>();

		jobs = authLocal.getJobRequetAssign(1);
		for (JobRequest jobRequest : jobs) {
			System.out.println(jobRequest.getDateApply());
			System.out.println(jobRequest.getSpeciality());
			System.out.println(jobRequest.getState() + "nader");
			// System.out.println(jobRequest.getDateApply());
			jobRequest.setUser(auth.lister(jobRequest.getDateApply()));
		}
		droppedCars = new ArrayList<JobRequest>();
	}

	public void onCarDrop(DragDropEvent ddEvent) {
		JobRequest car = ((JobRequest) ddEvent.getData());
		System.out.println("naderaaaaaaaaaaS");
		droppedCars.add(car);
		jobs.remove(car);
	}

	public String doJobRequestAssign(int id) {
		String navigateTo = "";
		// System.out.println("TEst1"+loginBean.getEmploye().getName());

		jobs = authLocal.getJobRequetAssign(1);
		for (JobRequest jobRequest : jobs) {
			System.out.println(jobRequest.getDateApply());
			System.out.println(jobRequest.getSpeciality());
			System.out.println(jobRequest.getState());
			// System.out.println(jobRequest.getDateApply());
			jobRequest.setUser(auth.lister(jobRequest.getDateApply()));
		}
		// droppedCars = new ArrayList<JobRequest>();

		navigateTo = "JobRequestAssign.jsf";
		return navigateTo;

	}

	public List<JobRequest> getJobs() {

		return jobs;
	}

	public void setJobs(List<JobRequest> jobs) {
		this.jobs = jobs;
	}

	public List<JobRequest> getDroppedCars() {
		return droppedCars;
	}

	public void setDroppedCars(List<JobRequest> droppedCars) {
		this.droppedCars = droppedCars;
	}

	public JobRequest getSelectedCar() {
		return selectedCar;
	}

	public void setSelectedCar(JobRequest selectedCar) {
		this.selectedCar = selectedCar;
	}

}
