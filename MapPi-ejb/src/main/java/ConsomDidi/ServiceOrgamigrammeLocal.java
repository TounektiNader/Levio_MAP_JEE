package ConsomDidi;

import java.util.List;

import javax.ejb.Local;

import Entity.Profil;
import Entity.Project;
import Entity.User;

@Local
public interface ServiceOrgamigrammeLocal {

	public List<User> getAllCostumer();
	public List<Project>getAllProjectClients(int id);
	public List<Profil> getAllProfilProject(int id);
}
