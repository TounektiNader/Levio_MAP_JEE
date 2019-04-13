package ConsomDidi;

import java.util.List;

import javax.ejb.Local;

import Entity.Project;

@Local
public interface ServiceProjetCustomerLocal {
    public List<Project> Consom(int id);
	public String hi();
}
