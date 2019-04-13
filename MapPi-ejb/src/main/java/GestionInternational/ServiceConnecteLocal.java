package GestionInternational;

import java.util.List;

import javax.ejb.Local;

import Entity.User;

@Local
public interface ServiceConnecteLocal {

	public User getUserConecte(String email);

	public List<User> getListUsers();

	public User lister(int id);

}
