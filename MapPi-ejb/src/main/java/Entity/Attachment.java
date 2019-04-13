package Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Attachments database table.
 * 
 */
@Entity
@Table(name="Attachments")
@NamedQuery(name="Attachment.findAll", query="SELECT a FROM Attachment a")
public class Attachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int attachmentId;

	private String lienAttachment;

	private String proved;

	private String typeAttachment;

	//bi-directional many-to-one association to Folder
	@ManyToOne
	@JoinColumn(name="folderId")
	private Folder folder;

	public Attachment() {
	}

	public int getAttachmentId() {
		return this.attachmentId;
	}

	public void setAttachmentId(int attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getLienAttachment() {
		return this.lienAttachment;
	}

	public void setLienAttachment(String lienAttachment) {
		this.lienAttachment = lienAttachment;
	}

	public String getProved() {
		return this.proved;
	}

	public void setProved(String proved) {
		this.proved = proved;
	}

	public String getTypeAttachment() {
		return this.typeAttachment;
	}

	public void setTypeAttachment(String typeAttachment) {
		this.typeAttachment = typeAttachment;
	}

	public Folder getFolder() {
		return this.folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

}