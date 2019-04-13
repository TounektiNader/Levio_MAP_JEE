package Utils;

import java.util.List;

import javax.ejb.Local;

//import Entity.Resource;
import Entity.Test;
import Entity.User;

@Local
public interface AuthentificationLocal {

	public void test();

	public String Authentification(User user);

	public String Register(User user);

	public User Authent(User user);

	public User lister(int id);
	
	public Test getTest();
	public List<User> findAllEmployye();

}
