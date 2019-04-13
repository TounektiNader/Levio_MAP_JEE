package ConsomDidi;

import java.util.List;

import javax.ejb.Local;

import Entity.User;

@Local
public interface ServiceProjetLocal {
	public List<User> Consommation() ;
	public String sayHello();

}
