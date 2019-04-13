package ClientDidi;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import ConsomDidi.AffecterProfilsToProject;
import ConsomDidi.ServiceProjectCustomer;
import Entity.Profil;
import Entity.Project;

@ManagedBean
@SessionScoped
public class ProfilBean {

	private int experience;

	private String speciality;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "projectId")
	private int project;
	@EJB
	AffecterProfilsToProject serviceP;

	private int idProject;
	
	List<Profil> listPro=new ArrayList<>();

	public int getProject() {
		return project;
	}

	public void setProject(int project) {
		this.project = project;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public AffecterProfilsToProject getServiceP() {
		return serviceP;
	}

	public void setServiceP(AffecterProfilsToProject serviceP) {
		this.serviceP = serviceP;
	}

	/*public String details(int id) {
		String navigateTo = "";
		// int idProjec = Integer.parseInt(id);
		idProject = id;
		//System.out.println(idProject);
		navigateTo = "AjoutProfil.jsf";
		return navigateTo;
	}*/
	
	public String details(int id) {
		String navigateTo = "";
		// int idProjec = Integer.parseInt(id);
		idProject = id;

		listPro=serviceP.listP(idProject);
		//System.out.println(idProject);
		navigateTo = "ListerProfil.jsf";
		return navigateTo;
	}
	
	public String Listerprofil(int id) {
		String navigateTo = "";
		// int idProjec = Integer.parseInt(id);
		idProject = id;
		System.out.println("prof"+idProject);
		navigateTo = "AjoutProfil.jsf";
		
		//listPro=serviceP.listP(idProject);
		return navigateTo;
		
	}

	public String addProfil() {
		String navigateTo = "";
		Profil profil = new Profil();
		profil.setExperience(experience);
		System.out.println(experience);
		profil.setSpeciality(speciality);
		profil.setProject(serviceP.findbyId(idProject));
		serviceP.ajouterProfil(profil);
		System.out.println("cccccc");
		navigateTo = "../ProjetClient.jsf";
		return "ProjetClient.jsf";
	}
	
	
	public List<Profil> listProfil(int p)
	{ 
		System.out.println(p);
		//return serviceP.listP(p.getProjectId());
	
		listPro=serviceP.listP(p);
	return listPro;
	}
	
	public void test()
	{ 
		System.out.println("testtt");
	
	}

	
	public void Supprimer(Integer id)
	{
		serviceP.SupprimerProfile(id);
		
		
	}
	public int getIdProject() {
		return idProject;
	}

	public void setIdProject(int idProject) {
		this.idProject = idProject;
	}

	public List<Profil> getListPro() {
		return listPro;
	}

	public void setListPro(List<Profil> listPro) {
		this.listPro = listPro;
	}

}
