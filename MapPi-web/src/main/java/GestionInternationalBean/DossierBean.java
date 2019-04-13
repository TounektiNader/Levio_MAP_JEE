package GestionInternationalBean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import Entity.AttachmentImmigrant;
import Entity.DossierImmigrant;
import Entity.EtapeDossier;
import Entity.EtatDossier;
import Entity.User;
import GestionInternational.ServiceAttachmentsLocal;
import GestionInternational.ServiceDossierImmigrantLocal;

@ManagedBean
@SessionScoped
public class DossierBean {

	@EJB
	ServiceDossierImmigrantLocal dossierLocal;

	@EJB
	ServiceAttachmentsLocal attachmentLocal;

	private DossierImmigrant dossier = new DossierImmigrant();
	private User user;
	private String pays;
	private int idUser;
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private String lettreEmbauche;
	private String motivation;
	private String statut;
	private String address;
	private String image;
	private String userId;

	private Part file;
	private Part file2;
	private String destination = "C:/Users/Nader/workspace/MapPi/MapPi-web/src/main/webapp/Attachment/";
	private InputStream inputStream;
	private InputStream inputStream2;

	private String fileName;
	private String fileName2;

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

	public void uploadFile2() throws IOException {
		System.out.println("bbbbbbbbbbbbb");

		if (file2 != null) {
			inputStream2 = file2.getInputStream();
			System.out.println("file name = " + file2.getName());
			fileName2 = file2.getSubmittedFileName();
			copyFile2(fileName2, inputStream2);
			// chequeObject.setImage("http://localhost:80/pi/" + fileName);
			System.out.println("localhost    :" + fileName2);
			file2 = null;
			inputStream2 = null;
		}
	}

	public void copyFile2(String fileName, InputStream in) {
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

	public List<String> ListOfGouverment() {

		List<String> G = new ArrayList<>();
		G.add("Afrique du Sud");
		G.add("Algérie");
		G.add("Allemagne");
		G.add("Argentine");
		G.add("Australie");
		G.add("Autriche");
		G.add("Belgique");
		G.add("Brésil");
		G.add("Canada");
		G.add("Chine");
		G.add("Colombie");
		G.add("Corée du Sud");
		G.add("Danemark");
		G.add("Espagne");
		G.add("France");
		G.add("Finlande");
		G.add("Grèce");
		G.add("Japon");
		G.add("Liban");
		G.add("Maroc");
		G.add("Suisse");
		G.add("Suède");
		G.add("Tunisie");

		return G;
	}

	public void ajoutFolder() throws IOException {
		uploadFile();
		uploadFile2();

		dossier.setImage(fileName);
		dossier.setLettreEmbauche(fileName2);
		dossier.setPays(pays);
		dossier.setStatut(statut);
		dossier.setMotivation(motivation);
		dossier.setEmail(email);
		dossier.setAddress(address);
		dossier.setLastName(lastName);
		dossier.setFirstName(firstName);
		dossier.setEtape(EtapeDossier.New);
		dossier.setPhone(phone);
		dossier.setIdUser(user.getId());
		dossier.setEtat(EtatDossier.BeingProcessed);
		System.out.println(dossier.getFirstName());
		dossierLocal.ajoutDossier(dossier);

		AttachmentImmigrant att = new AttachmentImmigrant();
		att.setName("Letter Employment");
		att.setPath(fileName2);

		// attachmentLocal.ajoutAttachment(att);
		dossierLocal.updateCoursEtEnseignant(dossier, att);
		dossier = new DossierImmigrant();

		// return "/TemplateClient/FolderSteps?faces-redirect=true";
	}

	public DossierImmigrant getDossier() {
		return dossier;
	}

	public void setDossier(DossierImmigrant dossier) {
		this.dossier = dossier;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLettreEmbauche() {
		return lettreEmbauche;
	}

	public void setLettreEmbauche(String lettreEmbauche) {
		this.lettreEmbauche = lettreEmbauche;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public Part getFile2() {
		return file2;
	}

	public void setFile2(Part file2) {
		this.file2 = file2;
	}

}
