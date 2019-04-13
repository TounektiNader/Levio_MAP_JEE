package ClientDidi;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import ConsomDidi.ServiceProjectCustomer;
import Entity.Project;
import Entity.User;
import tn.map.users.LoginBean;

@ManagedBean
@SessionScoped
public class ProjectBean {

	private String description;
	private int numberResource;
	private float price;
	private int nbJrsProlongation;
	private String state;

	//
	private User user;
	private int id;

	List<Project> listsPro;

	@EJB
	ServiceProjectCustomer servicePc;

	public List<Project> GetAllProjects() {
		for (Project project : servicePc.Consom(3004)) {
			System.out.println(project.getDescription());

		}
		return servicePc.Consom(3004);

	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getNumberResource() {
		return numberResource;
	}

	public void setNumberResource(int numberResource) {
		this.numberResource = numberResource;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNbJrsProlongation() {
		return nbJrsProlongation;
	}

	public void setNbJrsProlongation(int nbJrsProlongation) {
		this.nbJrsProlongation = nbJrsProlongation;
	}

	public String details() {
		String navigateTo = "";
		return navigateTo = "/AjoutProfil?faces-redirect=true";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Project> getListsPro() {
		listsPro = servicePc.Consom(3004);
		for (Project pro : listsPro) {
			System.out.println(pro.getDuration());

		}
		return listsPro;
	}

	public void setListsPro(List<Project> listsPro) {
		this.listsPro = listsPro;
	}

}
