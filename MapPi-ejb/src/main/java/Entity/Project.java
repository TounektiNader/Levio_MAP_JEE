package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Project database table.
 * 
 */
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int projectId;

	private String description;

	private int duration;

	private String endDay;

	private boolean isApprouve;

	private int nbJrsProlongation;

	private int numberResource;

	private float price;

	private double prixRetard;

	private String startDay;

	private String state;

	private int userId;

	//bi-directional many-to-one association to Mandate
	@OneToMany(mappedBy="project")
	private List<Mandate> mandates;

	//bi-directional many-to-one association to Profil
	@OneToMany(mappedBy="project")
	private List<Profil> profils;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_Id")
	private User user;

	//bi-directional many-to-many association to User
	@ManyToMany(mappedBy="projects2")
	private List<User> users;

	public Project() {
	}

	public int getProjectId() {
		return this.projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getEndDay() {
		return this.endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public boolean getIsApprouve() {
		return this.isApprouve;
	}

	public void setIsApprouve(boolean isApprouve) {
		this.isApprouve = isApprouve;
	}

	public int getNbJrsProlongation() {
		return this.nbJrsProlongation;
	}

	public void setNbJrsProlongation(int nbJrsProlongation) {
		this.nbJrsProlongation = nbJrsProlongation;
	}

	public int getNumberResource() {
		return this.numberResource;
	}

	public void setNumberResource(int numberResource) {
		this.numberResource = numberResource;
	}

	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public double getPrixRetard() {
		return this.prixRetard;
	}

	public void setPrixRetard(double prixRetard) {
		this.prixRetard = prixRetard;
	}

	public String getStartDay() {
		return this.startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Mandate> getMandates() {
		return this.mandates;
	}

	public void setMandates(List<Mandate> mandates) {
		this.mandates = mandates;
	}

	public Mandate addMandate(Mandate mandate) {
		getMandates().add(mandate);
		mandate.setProject(this);

		return mandate;
	}

	public Mandate removeMandate(Mandate mandate) {
		getMandates().remove(mandate);
		mandate.setProject(null);

		return mandate;
	}

	public List<Profil> getProfils() {
		return this.profils;
	}

	public void setProfils(List<Profil> profils) {
		this.profils = profils;
	}

	public Profil addProfil(Profil profil) {
		getProfils().add(profil);
		profil.setProject(this);

		return profil;
	}

	public Profil removeProfil(Profil profil) {
		getProfils().remove(profil);
		profil.setProject(null);

		return profil;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}