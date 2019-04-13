package tn.map.users;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entity.Role;
import Entity.User;
import GestionInternational.ServiceConnecte;
import GestionInternational.ServiceJobRequestLocal;
import GestionInternationalBean.DossierBean;
import GestionInternationalBean.FolderBean;
import Utils.AuthentificationLocal;

@ManagedBean
@SessionScoped
public class LoginBean {

	private String login;
	private String password;
	private String confirmPassword;
	private String firstname;
	private String lastname;
	private String address;
	// private Resource resource;
	@ManagedProperty("#{folderBean}") // OR localeBean, LocaleBean...
	private FolderBean folderBean;

	@ManagedProperty("#{dossierBean}") // OR localeBean, LocaleBean...
	private DossierBean dossierBean;

	// @ManagedProperty("#{consultBean}") // OR localeBean, LocaleBean...
	// private ConsultBean consultBean;

	private String phoneNumber;

	private Role cv;

	private User user;
	private User userConnecte;
	private boolean loggedIn = false;

	@EJB
	AuthentificationLocal authLocal;

	@EJB
	ServiceConnecte serviceConnecte;

	@EJB
	ServiceJobRequestLocal jobLocal;

	public String doLogin() {
		user = new User();
		user.setEmail(login);
		user.setPassword(password);
		System.out.println("qsdqsdqsAAAAA");
		String navigateTo = "";
		String test = authLocal.Authentification(user);
		if (test.equals("")) {

			System.out.println("qsdqsds");

			FacesMessage msg = new FacesMessage("Vérifier Votre Login Ou Mot de passe");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);

		} else {
			userConnecte = serviceConnecte.getUserConecte(user.getEmail());

			System.out.println(serviceConnecte.getUserConecte(user.getEmail()).getFirstname());
			loggedIn = true;

			if (serviceConnecte.lister(userConnecte.getId()).getRole().equals("Admin")) {

				navigateTo = "/TemplateAdmin/offerByFolder?faces-redirect=true";
			}

			else {
				folderBean.setFolder(jobLocal.getFolder(userConnecte.getId()));
				folderBean.setUser(userConnecte);
				dossierBean.setUser(userConnecte);
				// consultBean.setUser(userConnecte);
				navigateTo = "/TemplateClient/ContentC?faces-redirect=true";
			}

		}
		return navigateTo;
	}

	public String doRegister() {
		String navigateTo = "";

		if (cv.equals(Role.Resource)) {
			User resource = new User();
			resource.setPassword(password);
			resource.setEmail(login);
			resource.setPhoneNumber(phoneNumber);
			resource.setLastname(lastname);
			resource.setFirstname(firstname);
			resource.setCv("Resource");
			resource.setAddress(address);

			System.out.println(resource.toString());

			String test = authLocal.Register(resource);

			if (test.equals("")) {
				// FacesContext.getCurrentInstance().addMessage(null,
				// new FacesMessage("Welcome " + firstname + " " + lastname));
				FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credntials"));

			} else {

				navigateTo = "/TemplateClient/Login?faces-redirect=true";

			}

		} else if (cv.equals(Role.Customer)) {

			User customer = new User();
			customer.setPassword(password);
			customer.setEmail(login);
			customer.setPhoneNumber(phoneNumber);
			customer.setLastname(lastname);
			customer.setFirstname(firstname);
			customer.setCv("Resource");
			customer.setAddress(address);

			System.out.println(customer.toString());

			String test = authLocal.Register(customer);

			if (test.equals("")) {
				// FacesContext.getCurrentInstance().addMessage(null,
				// new FacesMessage("Welcome " + firstname + " " + lastname));
				FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credntials"));

			} else {

				navigateTo = "/TemplateClient/Login?faces-redirect=true";

			}

		}

		return navigateTo;
	}

	public String dologout() {
		String navigateTo = "";
		// FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		System.out.println("Deconnection");
		// loggedIn = false;
		navigateTo = "http://localhost:18080/MapPi-web/TemplateClient/Login.jsf";

		return navigateTo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Role getCv() {
		return cv;
	}

	public void setCv(Role cv) {
		this.cv = cv;
	}

	public Role[] getRoles() {

		return Role.values();
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public User getUserConnecte() {
		return userConnecte;
	}

	public void setUserConnecte(User userConnecte) {
		this.userConnecte = userConnecte;
	}

	public FolderBean getFolderBean() {
		return folderBean;
	}

	public void setFolderBean(FolderBean folderBean) {
		this.folderBean = folderBean;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public DossierBean getDossierBean() {
		return dossierBean;
	}

	public void setDossierBean(DossierBean dossierBean) {
		this.dossierBean = dossierBean;
	}

	// public ConsultBean getConsultBean() {
	// return consultBean;
	// }
	//
	// public void setConsultBean(ConsultBean consultBean) {
	// this.consultBean = consultBean;
	// }

}
