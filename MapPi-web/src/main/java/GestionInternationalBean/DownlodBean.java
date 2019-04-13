package GestionInternationalBean;

import java.io.InputStream;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.StreamedContent;

import Entity.AttachmentImmigrant;
import GestionInternational.ServiceAttachmentsLocal;

@ManagedBean
@SessionScoped
public class DownlodBean {

	private StreamedContent file;
	private int id;
	private InputStream inputStream;

	@EJB
	ServiceAttachmentsLocal attachmentLocal;

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void download() {

		AttachmentImmigrant att = attachmentLocal.getAttachment(1);
		try {

			FacesMessage message = new FacesMessage("", "");
			FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage("");
			FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

}
