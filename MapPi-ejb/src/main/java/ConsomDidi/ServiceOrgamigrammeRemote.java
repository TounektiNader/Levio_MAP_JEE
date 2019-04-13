package ConsomDidi;

import java.util.List;

import javax.ejb.Remote;

import Entity.Profil;
import Entity.Project;
import Entity.User;

@Remote
public interface ServiceOrgamigrammeRemote {
	public List<User> getAllCostumer();
	public List<Project>getAllProjectClients(int id);
	public List<Profil> getAllProfilProject(int id);

}
