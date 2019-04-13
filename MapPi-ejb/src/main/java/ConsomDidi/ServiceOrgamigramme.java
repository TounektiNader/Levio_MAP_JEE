package ConsomDidi;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import Entity.Profil;
import Entity.Project;
import Entity.User;


@Stateful
public class ServiceOrgamigramme  implements ServiceOrgamigrammeRemote,ServiceOrgamigrammeLocal{

	
	
	  @PersistenceContext(unitName="MapPi-ejb")
		EntityManager em;
	  
	@Override
	public List<User> getAllCostumer() {
		String role= "Customer";
		return em.createQuery("Select e.firstname,e.lastname from User e where e.role=:role",User.class)
				.setParameter("role",role).getResultList();
		
}

	@Override
	public List<Project> getAllProjectClients(int id2) {
		
	TypedQuery<Project> query = em.createQuery("select p from Project p JOIN p.userId u where u.userId=:id" , Project.class);
	query.setParameter("id",id2);
	return query.getResultList();
	}

	@Override
	public List<Profil> getAllProfilProject(int idP) {
		TypedQuery<Profil> query =em.createQuery("select prof from Profil prof JOIN prof.projectId=:id",Profil.class);
		query.setParameter("id", idP);
		return query.getResultList();
		
	
	
	
	}
}
