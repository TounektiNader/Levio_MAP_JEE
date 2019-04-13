package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the JobRequest database table.
 * 
 */
@Entity
@NamedQuery(name = "JobRequest.findAll", query = "SELECT j FROM JobRequest j")
public class JobRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int jobRequestId;

	private int dateApply;

	private String speciality;

	private String state;

	// bi-directional many-to-one association to Folder
	@OneToMany(mappedBy = "jobRequest")
	private List<Folder> folders;

	// bi-directional many-to-one association to OfferJob
	@ManyToOne
	@JoinColumn(name = "offerId")
	private OfferJob offerJob;

	// bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	public JobRequest() {
	}

	public int getJobRequestId() {
		return this.jobRequestId;
	}

	public void setJobRequestId(int jobRequestId) {
		this.jobRequestId = jobRequestId;
	}

	public int getDateApply() {
		return this.dateApply;
	}

	public void setDateApply(int dateApply) {
		this.dateApply = dateApply;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public List<Folder> getFolders() {
		return this.folders;
	}

	public void setFolders(List<Folder> folders) {
		this.folders = folders;
	}

	public Folder addFolder(Folder folder) {
		getFolders().add(folder);
		folder.setJobRequest(this);

		return folder;
	}

	public Folder removeFolder(Folder folder) {
		getFolders().remove(folder);
		folder.setJobRequest(null);

		return folder;
	}

	public OfferJob getOfferJob() {
		return this.offerJob;
	}

	public void setOfferJob(OfferJob offerJob) {
		this.offerJob = offerJob;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}