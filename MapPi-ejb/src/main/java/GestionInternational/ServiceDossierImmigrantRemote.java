package GestionInternational;

import java.util.List;

import javax.ejb.Remote;

import Entity.AttachmentImmigrant;
import Entity.DossierImmigrant;

@Remote
public interface ServiceDossierImmigrantRemote {

	public DossierImmigrant getDossierByUserId(int idUser);

	public List<DossierImmigrant> findAllDossier();

	public List<AttachmentImmigrant> listerCours(DossierImmigrant dossier);

	public void updateDossier(DossierImmigrant dossier);

	public void ajoutDossier(DossierImmigrant dossier);

	public void ajouterCoursEtEnseignant(DossierImmigrant dossier, AttachmentImmigrant attachment);

	public void updateDossierAttachment(DossierImmigrant dossier);

	public void updateCoursEtEnseignant(DossierImmigrant dossier, AttachmentImmigrant attachment);

	public void DeleteDossier(DossierImmigrant dossier);

	public List<DossierImmigrant> findAllDossier(String pays);

	public List<DossierImmigrant> findAllDossierAccepte();

	public DossierImmigrant findDossier(int id);

}
