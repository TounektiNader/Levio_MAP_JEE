package Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Mandate database table.
 * 
 */
@Entity
@NamedQuery(name="Mandate.findAll", query="SELECT m FROM Mandate m")
public class Mandate implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MandatePK id;

	private int cost;

	private int duration;

	private String endDate;

	private String startDate;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectId",insertable=false, updatable=false)
	private Project project;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="resource_Id", insertable=false, updatable=false)
	private User user;

	public Mandate() {
	}

	public MandatePK getId() {
		return this.id;
	}

	public void setId(MandatePK id) {
		this.id = id;
	}

	public int getCost() {
		return this.cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getDuration() {
		return this.duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}