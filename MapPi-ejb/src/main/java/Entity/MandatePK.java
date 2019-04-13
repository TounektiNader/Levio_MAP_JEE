package Entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Mandate database table.
 * 
 */
@Embeddable
public class MandatePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="projectId",insertable=false, updatable=false)
	private int projectId;
	@Column(name="resource_Id",insertable=false, updatable=false)
	private int userId;

	public MandatePK() {
	}
	public int getProjectId() {
		return this.projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MandatePK)) {
			return false;
		}
		MandatePK castOther = (MandatePK)other;
		return 
			(this.projectId == castOther.projectId)
			&& (this.userId == castOther.userId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.projectId;
		hash = hash * prime + this.userId;
		
		return hash;
	}
}