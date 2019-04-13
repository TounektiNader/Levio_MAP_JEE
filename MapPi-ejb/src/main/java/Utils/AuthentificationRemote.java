package Utils;

import java.util.List;

import javax.ejb.Remote;

//import Entity.Resource;
import Entity.Test;
import Entity.User;

@Remote
public interface AuthentificationRemote {
	public void test();

	public String Authentification(User user);

	public String Register(User user);

	public User Authent(User user);

	public User lister(int id);
	public Test getTest();
	public List<User> findAllEmployye();
}
