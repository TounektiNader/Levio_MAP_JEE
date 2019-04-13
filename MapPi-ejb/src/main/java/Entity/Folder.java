package Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Folder database table.
 * 
 */
@Entity
@NamedQuery(name="Folder.findAll", query="SELECT f FROM Folder f")
public class Folder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int folderId;

	private int etape;

	private String letterEmmployment;

	private String state;

	private float testResult;

	private String typeTest;

	//bi-directional many-to-one association to JobRequest
	@ManyToOne
	@JoinColumn(name="jobRequestId")
	private JobRequest jobRequest;

	public Folder() {
	}

	public int getFolderId() {
		return this.folderId;
	}

	public void setFolderId(int folderId) {
		this.folderId = folderId;
	}

	public int getEtape() {
		return this.etape;
	}

	public void setEtape(int etape) {
		this.etape = etape;
	}

	public String getLetterEmmployment() {
		return this.letterEmmployment;
	}

	public void setLetterEmmployment(String letterEmmployment) {
		this.letterEmmployment = letterEmmployment;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public float getTestResult() {
		return this.testResult;
	}

	public void setTestResult(float testResult) {
		this.testResult = testResult;
	}

	public String getTypeTest() {
		return this.typeTest;
	}

	public void setTypeTest(String typeTest) {
		this.typeTest = typeTest;
	}

	public JobRequest getJobRequest() {
		return this.jobRequest;
	}

	public void setJobRequest(JobRequest jobRequest) {
		this.jobRequest = jobRequest;
	}

}