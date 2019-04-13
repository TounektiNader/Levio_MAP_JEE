package ClientDidi;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ConsomDidi.ServiceProject;
import Entity.User;

@ManagedBean
@SessionScoped
public class CustomerBean {
	
	private String category;
	private String firstname;
	private String lastname;
	private String logo;
	private String address;
	private String speciality;
	private String type;
	private String description;
	
	







	@EJB
	ServiceProject serviceP;
	
	
	
	
	
	
	public List<User> GetAllClients()
	{
		System.out.println(serviceP.Consommation());
		
		return serviceP.Consommation();
		
	}
	
	
	
	public String getDescription() {
		return description;
	}







	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}







	public String getType() {
		return type;
	}







	public void setType(String type) {
		this.type = type;
	}







	
	
	
	
	

}
