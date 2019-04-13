package Entity;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AttachmentImmigrant
 *
 */
@Entity

public class AttachmentImmigrant implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String name;
	private String path;

	@ManyToOne(cascade = { CascadeType.PERSIST ,CascadeType.MERGE})
	private DossierImmigrant dossierAttachment;

	private static final long serialVersionUID = 1L;

	public AttachmentImmigrant() {
		super();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return this.path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public DossierImmigrant getDossierAttachment() {
		return dossierAttachment;
	}

	public void setDossierAttachment(DossierImmigrant dossierAttachment) {
		this.dossierAttachment = dossierAttachment;
	}
	
	

}
