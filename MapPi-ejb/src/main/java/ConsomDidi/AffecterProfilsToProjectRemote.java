package ConsomDidi;

import java.util.List;

import javax.ejb.Remote;

import Entity.Profil;
import Entity.Project;

@Remote
public interface AffecterProfilsToProjectRemote {
	public void AffecterProfAProj(int profilId, int projectId);
	public void ajouterProfil(Profil prof);
	public Project  findbyId(int id);
	public  List<Profil> listP(int id);
	public void SupprimerProfile(int id);

}
