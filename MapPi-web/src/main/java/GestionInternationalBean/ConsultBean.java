package GestionInternationalBean;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import Entity.DossierImmigrant;

import Entity.User;
import GestionInternational.ServiceDossierImmigrantLocal;
import tn.map.users.LoginBean;

@ManagedBean
@SessionScoped
public class ConsultBean {

	@EJB
	ServiceDossierImmigrantLocal dossierLocal;
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

	@ManagedProperty("#{loginBean}") // OR localeBean, LocaleBean...
	private LoginBean loginBean;

	public String doDetails() {
		String naviagto = "";
		dossier = new DossierImmigrant();
		dossier = dossierLocal.getDossierByUserId(loginBean.getUserConnecte().getId());
		//System.out.println(1);
		if (dossier == null) {
			//System.out.println(2);

			naviagto = "FormPostulerDossier.jsf";
			//System.out.println(3);
		}

		else {
			System.out.println(3);
			naviagto = "ConsultDossier.jsf";
			//System.out.println(4);
		}
		return naviagto;
	}

	public String testExistDossier() {

		String navigato = "";

		return navigato;
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

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

}
