package GestionInternationalBean;

import java.io.IOException;
import java.io.InputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import Entity.Ministere;
import GestionInternational.ServiceMinistereLocal;

@ManagedBean
@SessionScoped
public class MinistereBean {

	private String email;
	private String pays;
	private String QrCode;
	// private Part file;
	private String photo = "";
	private Ministere ministere = new Ministere();
	private boolean loggedIn = false;

	private Part file;
	private String destination = "C:/Users/Nader/workspace/MapPi/MapPi-web/src/main/webapp/ImagesVerif/";
	private InputStream inputStream;
	private String fileName;

	@EJB
	ServiceMinistereLocal ministLocal;

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

	public List<String> ListOfCountry() {

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

	public String verifier() throws IOException {
		String navigateTo = "";

		uploadFile();
		System.out.println(email);
		String qrCodeEmailBD = ministLocal.getMinistereByEmailVerif(email).getQrCode();
		String qrCodeEmailUpload = fileName;
		if (ministLocal.getMinistereByEmailVerif(email) == null) {

			FacesMessage msg = new FacesMessage("Vérifier Votre Login Ou Mot de passe");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);

		}

		else {
			if (ministLocal.ReadQrCode(qrCodeEmailBD, qrCodeEmailUpload)) {
				loggedIn = true;

				// bech nzidou navigato To
				navigateTo = "/TemplateClient/GestionDossier?faces-redirect=true";
			} else {
				System.out.println("Falseeee");
			}
		}
		return navigateTo;

	}

	public String dologout() {
		String navigateTo = "";
		// FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		System.out.println("Deconnection");
		// loggedIn = false;
		navigateTo = "/TemplateClient/MinistereLogin?faces-redirect=true";

		return navigateTo;
	}

	public String doRegister() {
		String navigateTo = "";

		if (ministLocal.RegisterMinistere(ministere)) {
			ministLocal.updateMinisterQrCode(ministere.getEmail(), ministere.getPays());
			SendMail.sendEMail(ministere.getEmail(), "Bienveue", "TOUNEKTI", "NADER");

			navigateTo = "/TemplateClient/Login?faces-redirect=true";
			ministere = new Ministere();
		}

		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credntials"));
			ministere = new Ministere();
		}

		return navigateTo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getQrCode() {
		return QrCode;
	}

	public void setQrCode(String qrCode) {
		QrCode = qrCode;
	}

	public Ministere getMinistere() {
		return ministere;
	}

	public void setMinistere(Ministere ministere) {
		this.ministere = ministere;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

}
