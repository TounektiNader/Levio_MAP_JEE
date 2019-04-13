package ConsomDidi;
import java.util.List;

import javax.ejb.Local;

import Entity.Profil;


@Local
public interface AffecterProfilsToProjectLocal {
	public void AffecterProfAProj(int profilId, int projectId);
	public void ajouterProfil(Profil prof);
	public  List<Profil> listP(int id);
	public void SupprimerProfile(int id);
}
