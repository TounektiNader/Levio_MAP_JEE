package GestionInternationalBean;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import Entity.DossierImmigrant;
import Entity.EtapeDossier;
import Entity.Ministere;
import GestionInternational.ServiceDossierImmigrantLocal;
import GestionInternational.ServiceMinistereLocal;

@ManagedBean
@SessionScoped
public class GdossierBean {

	@EJB
	ServiceDossierImmigrantLocal dossierLocal;

	@EJB
	ServiceMinistereLocal ministreLocal;

	private DossierImmigrant dossier = new DossierImmigrant();
	private boolean btnadd = true;
	private boolean btnedit = false;
	private boolean read;
	private Ministere ministre;

	private EtapeDossier etapeDossier;

	public List<EtapeDossier> etapeDossiers() {
		List<EtapeDossier> G = new ArrayList<>();
		G.add(EtapeDossier.New);
		G.add(EtapeDossier.Treatment);
		G.add(EtapeDossier.Interview);
		G.add(EtapeDossier.Completed);
		return G;
	}

	private List<DossierImmigrant> listDossiers;

	public void clickAdd() {
		dossier = new DossierImmigrant();
		read = false;
		btnadd = true;
		btnedit = false;

	}

	public void clickEdit() {
		btnadd = false;
		btnedit = true;
		read = true;

	}

	@ManagedProperty("#{ministereBean}") // OR localeBean, LocaleBean...
	private MinistereBean ministereBean;

	public String doInterview() {
		String navitaoTo = "";
		// int idUSer = Integer.parseInt(id);
		// ministre = Mini.getDoctor(idUSer);
		// System.out.println(user.getId());
		// System.out.println(user.getFirstName());
		navitaoTo = "EntretienC.jsf";

		return navitaoTo;
	}

	public void supprimer() {

		try {
			dossierLocal.DeleteDossier(dossier);
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Suppression avec succès"));
			dossier = new DossierImmigrant();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void updaetDossier() {

		try {
			dossierLocal.updateDossier(dossier);

			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Modificiation effectuer avec succès "));
			dossier = new DossierImmigrant();
			btnadd = true;
			btnedit = false;

		} catch (Exception e) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			facesContext.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Erreur de Modification"));
			e.printStackTrace();
		}

	}

	public List<DossierImmigrant> getListDossiers() {

		listDossiers = dossierLocal
				.findAllDossier(ministreLocal.getMinistereByEmailVerif(ministereBean.getEmail()).getPays());
		return listDossiers;
	}

	public void setListDossiers(List<DossierImmigrant> listDossiers) {
		this.listDossiers = listDossiers;
	}

	public DossierImmigrant getDossier() {
		return dossier;
	}

	public void setDossier(DossierImmigrant dossier) {
		this.dossier = dossier;
	}

	public boolean isBtnadd() {
		return btnadd;
	}

	public void setBtnadd(boolean btnadd) {
		this.btnadd = btnadd;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean isBtnedit() {
		return btnedit;
	}

	public void setBtnedit(boolean btnedit) {
		this.btnedit = btnedit;
	}

	public EtapeDossier getEtapeDossier() {
		return etapeDossier;
	}

	public void setEtapeDossier(EtapeDossier etapeDossier) {
		this.etapeDossier = etapeDossier;
	}

	public void annuler() {

		dossier = new DossierImmigrant();
		btnadd = true;
		btnedit = false;
	}

	public Ministere getMinistre() {
		return ministre;
	}

	public void setMinistre(Ministere ministre) {
		this.ministre = ministre;
	}

	public MinistereBean getMinistereBean() {
		return ministereBean;
	}

	public void setMinistereBean(MinistereBean ministereBean) {
		this.ministereBean = ministereBean;
	}

	// public List<EtapeDossier> getEtapeDossiers() {
	// //etapeDossiers=EtapeDossier.values();
	// return etapeDossiers;
	// }
	//
	//
	//
	// public void setEtapeDossiers(List<EtapeDossier> etapeDossiers) {
	// this.etapeDossiers = etapeDossiers;
	// }

}
