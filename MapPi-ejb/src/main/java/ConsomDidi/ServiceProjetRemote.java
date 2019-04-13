package ConsomDidi;

import java.util.List;

import javax.ejb.Remote;

import Entity.User;

@Remote
public interface ServiceProjetRemote {
	public List<User> Consommation() ;
	public String sayHello();

}
