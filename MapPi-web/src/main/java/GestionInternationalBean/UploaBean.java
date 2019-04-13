package GestionInternationalBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import Entity.AttachmentImmigrant;
import Entity.DossierImmigrant;
import GestionInternational.ServiceAttachmentsLocal;
import GestionInternational.ServiceDossierImmigrantLocal;
import tn.map.users.LoginBean;

@ManagedBean
@SessionScoped
public class UploaBean {
	@ManagedProperty("#{loginBean}") // OR localeBean, LocaleBean...
	private LoginBean loginBean;
	private Part file;
	private List<AttachmentImmigrant> lists;

	private AttachmentImmigrant attachment = new AttachmentImmigrant();
	private String type="";
	private String destination = "C:/Users/Nader/workspace/MapPi/MapPi-web/src/main/webapp/Attachment/";
	private InputStream inputStream;
	private String fileName;

	private String pathpdf;
	@EJB
	ServiceAttachmentsLocal attachmentLocal;
	@EJB
	ServiceDossierImmigrantLocal dossierLocal;
	private DossierImmigrant dossier = new DossierImmigrant();

	public void uploadFile() throws IOException {
		System.out.println("aaaaaaaaaaaaaaaaaaa");

		if (file != null) {
			inputStream = file.getInputStream();
			System.out.println("file name = " + file.getName());
			fileName = file.getSubmittedFileName();
			copyFile(fileName, inputStream);
			// chequeObject.setImage("http://localhost:80/pi/" + fileName);
			System.out.println("localhost    :" + fileName);
			file = null;
			inputStream = null;
		}
	}

	public void copyFile(String fileName, InputStream in) {
		try {
			OutputStream out = new FileOutputStream(new File(destination + fileName));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			in.close();
			out.flush();
			out.close();
			System.out.println("New file created!");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public String addAttachment() throws IOException {
		String navigato = "";
		uploadFile();
		dossier = new DossierImmigrant();
		dossier = dossierLocal.getDossierByUserId(loginBean.getUserConnecte().getId());

		////////////////////
		attachment.setPath(fileName);
		attachment.setName(type);

		dossierLocal.updateCoursEtEnseignant(dossier, attachment);

		System.out.println("**************************************************************");
		attachment = new AttachmentImmigrant();
		navigato = "UploadAttachment.jsf";

		return navigato;
	}

	// public void upload() {
	// try {
	// if (file != null) {
	//
	// attachment = new AttachmentImmigrant();
	// attachment.setName("Nader");
	// attachment.setPath(file.getFileName());
	// attachmentLocal.ajoutAttachment(attachment);
	// FacesMessage message = new FacesMessage("", file.getFileName() + " ");
	// FacesContext.getCurrentInstance().addMessage(null, message);
	// }
	// } catch (Exception e) {
	// FacesMessage message = new FacesMessage("");
	// FacesContext.getCurrentInstance().addMessage(null, message);
	// }
	// }

	public String displayPdf(String path) {
		String navigato = "";
		
		System.out.println("bech nafishiw path "+path);
		pathpdf = path;
		navigato = "DisplayPdf.jsf";
		return navigato;
	}

	public String deleteAttachment(String id) {
		String navigato = "";
		int idAttachment = Integer.parseInt(id);

		attachmentLocal.DeleteAttachment(idAttachment);
		navigato = "UploadAttachment.jsf";
		return navigato;
	}

	public AttachmentImmigrant getAttachment() {
		return attachment;
	}

	public void setAttachment(AttachmentImmigrant attachment) {
		this.attachment = attachment;
	}

	public ServiceAttachmentsLocal getAttachmentLocal() {
		return attachmentLocal;
	}

	public void setAttachmentLocal(ServiceAttachmentsLocal attachmentLocal) {
		this.attachmentLocal = attachmentLocal;
	}

	public List<AttachmentImmigrant> getLists() {
		dossier = new DossierImmigrant();
		dossier = dossierLocal.getDossierByUserId(loginBean.getUserConnecte().getId());
		System.out.println(dossier.getFirstName());

		lists = dossier.getAttachments();
		System.out.println(lists.get(0).getPath());
		return lists;
	}

	public void setLists(List<AttachmentImmigrant> lists) {

		this.lists = lists;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public DossierImmigrant getDossier() {
		return dossier;
	}

	public void setDossier(DossierImmigrant dossier) {
		this.dossier = dossier;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String getPathpdf() {
		return pathpdf;
	}

	public void setPathpdf(String pathpdf) {
		this.pathpdf = pathpdf;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

}
