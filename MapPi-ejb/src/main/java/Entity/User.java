package Entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * The persistent class for the User database table.
 * 
 */
@Entity
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "role")
// @DiscriminatorValue("User")
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
@Table(name = "User")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int id;

	@Column(name = "AccessFailedCount")
	private int accessFailedCount;
	@Column(name = "address")
	private String address;

	@Column(name = "businessSector")
	private String businessSector;

	@Column(name = "category")
	private String category;

	@Column(name = "CV")
	private String cv;

	@Column(name = "description")
	private String description;

	@Column(name = "Email")
	private String email;

	@Column(name = "EmailConfirmed")
	private boolean emailConfirmed;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "grade")
	private String grade;

	@Column(name = "image")
	private String image;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "LockoutEnabled")
	private boolean lockoutEnabled;

	@Column(name = "LockoutEndDateUtc")
	private Timestamp lockoutEndDateUtc;

	@Column(name = "Login")
	private String login;

	@Column(name = "logo")
	private String logo;

	@Column(name = "motDePasse")
	private String motDePasse;

	@Column(name = "password")
	private String password;

	@Column(name = "PhoneNumber")
	private String phoneNumber;

	@Column(name = "PhoneNumberConfirmed")
	private boolean phoneNumberConfirmed;

	@Column(name = "role")
	private String role;

	@Column(name = "score")
	private String score;

	@Column(name = "SecurityStamp")
	private String securityStamp;

	@Column(name = "speciality")
	private String speciality;

	@Column(name = "TwoFactorEnabled")
	private boolean twoFactorEnabled;

	@Column(name = "type")
	private String type;

	@Column(name = "type1")
	private String type1;

	// bi-directional many-to-one association to Answer
	@OneToMany(mappedBy = "user")
	private List<Answer> answers;

	// bi-directional many-to-one association to Availibility
	@OneToMany(mappedBy = "user")
	private List<Availibility> availibilities;

	// bi-directional many-to-one association to Claim
	@OneToMany(mappedBy = "user")
	private List<Claim> claims;

	// bi-directional many-to-one association to CustomUserClaim
	@OneToMany(mappedBy = "user")
	private List<CustomUserClaim> customUserClaims;

	// bi-directional many-to-one association to CustomUserLogin
	@OneToMany(mappedBy = "user")
	private List<CustomUserLogin> customUserLogins;

	// bi-directional many-to-one association to JobRequest
	@OneToMany(mappedBy = "user")
	private List<JobRequest> jobRequests;

	// bi-directional many-to-one association to Message
	@OneToMany(mappedBy = "user1")
	private List<Message> messages1;

	// bi-directional many-to-one association to Message
	@OneToMany(mappedBy = "user2")
	private List<Message> messages2;

	// bi-directional many-to-one association to OfferJob
	@OneToMany(mappedBy = "user")
	private List<OfferJob> offerJobs;

	// bi-directional many-to-one association to Project
	@OneToMany(mappedBy = "user")
	private List<Project> projects1;

	// bi-directional many-to-one association to Test
	@OneToMany(mappedBy = "user")
	private List<Test> tests;

	// bi-directional many-to-many association to Project
	@ManyToMany
	@JoinTable(name = "ProjectResources", joinColumns = { @JoinColumn(name = "Resource_Id") }, inverseJoinColumns = {
			@JoinColumn(name = "Project_projectId") })
	private List<Project> projects2;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccessFailedCount() {
		return this.accessFailedCount;
	}

	public void setAccessFailedCount(int accessFailedCount) {
		this.accessFailedCount = accessFailedCount;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBusinessSector() {
		return this.businessSector;
	}

	public void setBusinessSector(String businessSector) {
		this.businessSector = businessSector;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getCv() {
		return this.cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean getEmailConfirmed() {
		return this.emailConfirmed;
	}

	public void setEmailConfirmed(boolean emailConfirmed) {
		this.emailConfirmed = emailConfirmed;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public boolean getLockoutEnabled() {
		return this.lockoutEnabled;
	}

	public void setLockoutEnabled(boolean lockoutEnabled) {
		this.lockoutEnabled = lockoutEnabled;
	}

	public Timestamp getLockoutEndDateUtc() {
		return this.lockoutEndDateUtc;
	}

	public void setLockoutEndDateUtc(Timestamp lockoutEndDateUtc) {
		this.lockoutEndDateUtc = lockoutEndDateUtc;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogo() {
		return this.logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getMotDePasse() {
		return this.motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean getPhoneNumberConfirmed() {
		return this.phoneNumberConfirmed;
	}

	public void setPhoneNumberConfirmed(boolean phoneNumberConfirmed) {
		this.phoneNumberConfirmed = phoneNumberConfirmed;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getSecurityStamp() {
		return this.securityStamp;
	}

	public void setSecurityStamp(String securityStamp) {
		this.securityStamp = securityStamp;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public boolean getTwoFactorEnabled() {
		return this.twoFactorEnabled;
	}

	public void setTwoFactorEnabled(boolean twoFactorEnabled) {
		this.twoFactorEnabled = twoFactorEnabled;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getType1() {
		return this.type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public List<Answer> getAnswers() {
		return this.answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Answer addAnswer(Answer answer) {
		getAnswers().add(answer);
		answer.setUser(this);

		return answer;
	}

	public Answer removeAnswer(Answer answer) {
		getAnswers().remove(answer);
		answer.setUser(null);

		return answer;
	}

	public List<Availibility> getAvailibilities() {
		return this.availibilities;
	}

	public void setAvailibilities(List<Availibility> availibilities) {
		this.availibilities = availibilities;
	}

	public Availibility addAvailibility(Availibility availibility) {
		getAvailibilities().add(availibility);
		availibility.setUser(this);

		return availibility;
	}

	public Availibility removeAvailibility(Availibility availibility) {
		getAvailibilities().remove(availibility);
		availibility.setUser(null);

		return availibility;
	}

	public List<Claim> getClaims() {
		return this.claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public Claim addClaim(Claim claim) {
		getClaims().add(claim);
		claim.setUser(this);

		return claim;
	}

	public Claim removeClaim(Claim claim) {
		getClaims().remove(claim);
		claim.setUser(null);

		return claim;
	}

	public List<CustomUserClaim> getCustomUserClaims() {
		return this.customUserClaims;
	}

	public void setCustomUserClaims(List<CustomUserClaim> customUserClaims) {
		this.customUserClaims = customUserClaims;
	}

	public CustomUserClaim addCustomUserClaim(CustomUserClaim customUserClaim) {
		getCustomUserClaims().add(customUserClaim);
		customUserClaim.setUser(this);

		return customUserClaim;
	}

	public CustomUserClaim removeCustomUserClaim(CustomUserClaim customUserClaim) {
		getCustomUserClaims().remove(customUserClaim);
		customUserClaim.setUser(null);

		return customUserClaim;
	}

	public List<CustomUserLogin> getCustomUserLogins() {
		return this.customUserLogins;
	}

	public void setCustomUserLogins(List<CustomUserLogin> customUserLogins) {
		this.customUserLogins = customUserLogins;
	}

	public CustomUserLogin addCustomUserLogin(CustomUserLogin customUserLogin) {
		getCustomUserLogins().add(customUserLogin);
		customUserLogin.setUser(this);

		return customUserLogin;
	}

	public CustomUserLogin removeCustomUserLogin(CustomUserLogin customUserLogin) {
		getCustomUserLogins().remove(customUserLogin);
		customUserLogin.setUser(null);

		return customUserLogin;
	}

	public List<JobRequest> getJobRequests() {
		return this.jobRequests;
	}

	public void setJobRequests(List<JobRequest> jobRequests) {
		this.jobRequests = jobRequests;
	}

	public JobRequest addJobRequest(JobRequest jobRequest) {
		getJobRequests().add(jobRequest);
		jobRequest.setUser(this);

		return jobRequest;
	}

	public JobRequest removeJobRequest(JobRequest jobRequest) {
		getJobRequests().remove(jobRequest);
		jobRequest.setUser(null);

		return jobRequest;
	}

	public List<Message> getMessages1() {
		return this.messages1;
	}

	public void setMessages1(List<Message> messages1) {
		this.messages1 = messages1;
	}

	public Message addMessages1(Message messages1) {
		getMessages1().add(messages1);
		messages1.setUser1(this);

		return messages1;
	}

	public Message removeMessages1(Message messages1) {
		getMessages1().remove(messages1);
		messages1.setUser1(null);

		return messages1;
	}

	public List<Message> getMessages2() {
		return this.messages2;
	}

	public void setMessages2(List<Message> messages2) {
		this.messages2 = messages2;
	}

	public Message addMessages2(Message messages2) {
		getMessages2().add(messages2);
		messages2.setUser2(this);

		return messages2;
	}

	public Message removeMessages2(Message messages2) {
		getMessages2().remove(messages2);
		messages2.setUser2(null);

		return messages2;
	}

	public List<OfferJob> getOfferJobs() {
		return this.offerJobs;
	}

	public void setOfferJobs(List<OfferJob> offerJobs) {
		this.offerJobs = offerJobs;
	}

	public OfferJob addOfferJob(OfferJob offerJob) {
		getOfferJobs().add(offerJob);
		offerJob.setUser(this);

		return offerJob;
	}

	public OfferJob removeOfferJob(OfferJob offerJob) {
		getOfferJobs().remove(offerJob);
		offerJob.setUser(null);

		return offerJob;
	}

	public List<Project> getProjects1() {
		return this.projects1;
	}

	public void setProjects1(List<Project> projects1) {
		this.projects1 = projects1;
	}

	public Project addProjects1(Project projects1) {
		getProjects1().add(projects1);
		projects1.setUser(this);

		return projects1;
	}

	public Project removeProjects1(Project projects1) {
		getProjects1().remove(projects1);
		projects1.setUser(null);

		return projects1;
	}

	public List<Test> getTests() {
		return this.tests;
	}

	public void setTests(List<Test> tests) {
		this.tests = tests;
	}

	public Test addTest(Test test) {
		getTests().add(test);
		test.setUser(this);

		return test;
	}

	public Test removeTest(Test test) {
		getTests().remove(test);
		test.setUser(null);

		return test;
	}

	public List<Project> getProjects2() {
		return this.projects2;
	}

	public void setProjects2(List<Project> projects2) {
		this.projects2 = projects2;
	}

}