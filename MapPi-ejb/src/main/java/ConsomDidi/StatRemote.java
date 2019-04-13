package ConsomDidi;

import java.util.List;

import javax.ejb.Remote;

import Entity.Project;
import Entity.User;

@Remote
public interface StatRemote {
	public List<Object[]> getAllCostumer() ;
	public Integer NbrProjectClients(int id);
	public List<Object[]> getAllProj() ;
}
