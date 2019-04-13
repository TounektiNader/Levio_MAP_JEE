package Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Availibility database table.
 * 
 */
@Entity
@NamedQuery(name="Availibility.findAll", query="SELECT a FROM Availibility a")
public class Availibility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int availibilityId;

	private String endDay;

	private String name;

	private int nnumberDays;

	private int numberDays;

	private int numberDaysRemaining;

	private String reason;

	private String startDay;

	private String state;

	private String type;

	private int userId;

	//bi-directional many-to-one association to User
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="resource_Id")
	private User user;

	public Availibility() {
	}

	public int getAvailibilityId() {
		return this.availibilityId;
	}

	public void setAvailibilityId(int availibilityId) {
		this.availibilityId = availibilityId;
	}

	public String getEndDay() {
		return this.endDay;
	}

	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNnumberDays() {
		return this.nnumberDays;
	}

	public void setNnumberDays(int nnumberDays) {
		this.nnumberDays = nnumberDays;
	}

	public int getNumberDays() {
		return this.numberDays;
	}

	public void setNumberDays(int numberDays) {
		this.numberDays = numberDays;
	}

	public int getNumberDaysRemaining() {
		return this.numberDaysRemaining;
	}

	public void setNumberDaysRemaining(int numberDaysRemaining) {
		this.numberDaysRemaining = numberDaysRemaining;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}