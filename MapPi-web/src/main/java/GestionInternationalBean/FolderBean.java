package GestionInternationalBean;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import Entity.Folder;
import Entity.User;
import GestionInternational.ServiceJobRequestLocal;
import tn.map.users.LoginBean;

@ManagedBean
@SessionScoped
public class FolderBean {

	// LoginBean locale = (LoginBean)
	// FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
	// .get("loginBean");

	@EJB
	ServiceJobRequestLocal jobLocal;

	private Folder folder;
	private User user;

	public String redirectFolder() {
		// folder = jobLocal.getFolder(3);
		// System.out.println(loginBean.getUser());
		return "/TemplateClient/FolderSteps?faces-redirect=true";
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
