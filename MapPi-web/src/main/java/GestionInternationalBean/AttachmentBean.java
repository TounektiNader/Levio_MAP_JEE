package GestionInternationalBean;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import Entity.AttachmentImmigrant;
import Entity.DossierImmigrant;
import GestionInternational.ServiceDossierImmigrantLocal;

@ManagedBean
@SessionScoped
public class AttachmentBean {

	@EJB
	ServiceDossierImmigrantLocal dossierLocal;

	private DossierImmigrant dossier = new DossierImmigrant();
	private List<AttachmentImmigrant> attachmentsImmigrants;

	public String getAttachments(int id) {

		String navigato = "";
		System.out.println("nader nader");
		dossier = dossierLocal.findDossier(id);
		for (AttachmentImmigrant attachmentImmigrant : dossier.getAttachments()) {
			System.out.println(attachmentImmigrant.getId());
		}

		attachmentsImmigrants = dossier.getAttachments();

		navigato = "ListAttachment.jsf";
		return navigato;
	}

	public List<AttachmentImmigrant> getAttachmentsImmigrants() {
		return attachmentsImmigrants;
	}

	public void setAttachmentsImmigrants(List<AttachmentImmigrant> attachmentsImmigrants) {
		this.attachmentsImmigrants = attachmentsImmigrants;
	}

}
