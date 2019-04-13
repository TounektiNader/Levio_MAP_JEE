package GestionInternational;

import java.util.List;

import javax.ejb.Remote;

import Entity.User;

@Remote
public interface ServiceConnecteRemote {

	public User getUserConecte(String email);

	public List<User> getListUsers();

	public User lister(int id);

}
