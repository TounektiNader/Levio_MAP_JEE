package GestionInternationalBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import Entity.Folder;
import Entity.JobRequest;
import GestionInternational.ServiceJobRequestLocal;
import Utils.AuthentificationLocal;

@ManagedBean
@SessionScoped
public class JobRequestBean {
	private List<JobRequest> jobs;

	@EJB
	ServiceJobRequestLocal authLocal;

	@EJB
	AuthentificationLocal auth;

	private int idoffer;

	public String doJobRequest(int id) {
		String navigateTo = "";
		// System.out.println("TEst1"+loginBean.getEmploye().getName());

		// System.out.println(id);
		idoffer = id;
		jobs = authLocal.getJobRequestByOffer(id);
		for (JobRequest jobRequest : jobs) {

			 System.out.println(jobRequest.getDateApply());
			jobRequest.setUser(auth.lister(jobRequest.getDateApply()));
		}

		navigateTo = "JobRequestByOffer.jsf";
		return navigateTo;

	}

	public String doAssign(int id) {
		String navigateTo = "";
		// System.out.println("TEst1"+loginBean.getEmploye().getName());

		// System.out.println(idoffer);
		// Folder folder = authLocal.getFolder(idoffer);

		//authLocal.updateFolderToAssign(authLocal.getFolder(id).getFolderId());
		//
		// for (JobRequest jobRequest : jobs) {
		//
		// System.out.println(jobRequest.getDateApply());
		// jobRequest.setUser(auth.lister(jobRequest.getDateApply()));
		// }

		navigateTo = "JobRequestAssign.jsf";
		return navigateTo;

	}

	public List<JobRequest> getJobs() {

		return jobs;
	}

	public void setJobs(List<JobRequest> jobs) {
		this.jobs = jobs;
	}

	public int getIdoffer() {
		return idoffer;
	}

	public void setIdoffer(int idoffer) {
		this.idoffer = idoffer;
	}

}
