package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the OfferJobs database table.
 * 
 */
@Entity
@Table(name="OfferJobs")
@NamedQuery(name="OfferJob.findAll", query="SELECT o FROM OfferJob o")
public class OfferJob implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int offerId;

	@Column(name="ExpectedSalary")
	private String ExpectedSalary;

	@Column(name="JobDescription")
	private String JobDescription;

	@Column(name="JobExperience")
	private String JobExperience;

	@Column(name="JobRequirements")
	private String jobRequirements;

	@Column(name="JobType")
	private String JobType;

	@Column(name="LastDay")
	private String LastDay;

	@Column(name="PostedOn")
	private String PostedOn;

	//bi-directional many-to-one association to JobRequest
	@OneToMany(mappedBy="offerJob")
	private List<JobRequest> jobRequests;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;

	public OfferJob() {
	}

	public int getOfferId() {
		return this.offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public String getExpectedSalary() {
		return this.ExpectedSalary;
	}

	public void setExpectedSalary(String expectedSalary) {
		this.ExpectedSalary = expectedSalary;
	}

	public String getJobDescription() {
		return this.JobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.JobDescription = jobDescription;
	}

	public String getJobExperience() {
		return this.JobExperience;
	}

	public void setJobExperience(String jobExperience) {
		this.JobExperience = jobExperience;
	}

	public String getJobRequirements() {
		return this.jobRequirements;
	}

	public void setJobRequirements(String jobRequirements) {
		this.jobRequirements = jobRequirements;
	}

	public String getJobType() {
		return this.JobType;
	}

	public void setJobType(String jobType) {
		this.JobType = jobType;
	}

	public String getLastDay() {
		return this.LastDay;
	}

	public void setLastDay(String lastDay) {
		this.LastDay = lastDay;
	}

	public String getPostedOn() {
		return this.PostedOn;
	}

	public void setPostedOn(String postedOn) {
		this.PostedOn = postedOn;
	}

	public List<JobRequest> getJobRequests() {
		return this.jobRequests;
	}

	public void setJobRequests(List<JobRequest> jobRequests) {
		this.jobRequests = jobRequests;
	}

	public JobRequest addJobRequest(JobRequest jobRequest) {
		getJobRequests().add(jobRequest);
		jobRequest.setOfferJob(this);

		return jobRequest;
	}

	public JobRequest removeJobRequest(JobRequest jobRequest) {
		getJobRequests().remove(jobRequest);
		jobRequest.setOfferJob(null);

		return jobRequest;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}