package ConsomDidi;

import java.util.List;

import javax.ejb.Remote;

import Entity.Project;

@Remote
public interface ServiceProjectCustomerRemote {
	
	public List<Project> Consom(int id);
	public String hi();
}
